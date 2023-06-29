package tests;

import base.BasePage;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class TestElements extends BasePage {

    HomePage homePage;
    SidePannelPage sidePannelPage;
    TextBoxPage textBoxPage;
    CheckBoxPage checkBoxPage;
    RadioButtonsPage radioButtonsPage;
    WebTablesPage webTablesPage;
    ButtonsPage buttonsPage;

    @BeforeMethod
    public void startSession(){
        homePage = new HomePage();
        sidePannelPage = new SidePannelPage();
        textBoxPage = new TextBoxPage();
        checkBoxPage = new CheckBoxPage();
        radioButtonsPage = new RadioButtonsPage();
        webTablesPage = new WebTablesPage();
        buttonsPage = new ButtonsPage();
        driver.get(homeURL);
        homePage.clickOnElementsCardButton();
    }

    @Description("Verify that a user can successfully submit their data if they insert valid personal data")
    @Test (groups = {"TextBox"})
    public void userCanSubmitDataInTheTextBox(){
        sidePannelPage.clickOnTextBoxItem();
        textBoxPage.insertFullName(excelReader.getStringData("TextBox", 2, 0));
        textBoxPage.insertEmail(excelReader.getStringData("TextBox", 2, 1));
        textBoxPage.insertCurrentAddress(excelReader.getStringData("TextBox", 2, 2));
        textBoxPage.insertPermanentAddress(excelReader.getStringData("TextBox", 2, 3));
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(textBoxPage.presenceOfOutputBox());
        String expectedResultFullName = excelReader.getStringData("TextBox", 2, 4);
        Assert.assertEquals(textBoxPage.getResultFullName(), expectedResultFullName);
        String expectedResultEmail = excelReader.getStringData("TextBox", 2, 5);
        Assert.assertEquals(textBoxPage.getResultEmail(), expectedResultEmail);
        String expectedResultCurrentAddress = excelReader.getStringData("TextBox", 2, 6);
        Assert.assertEquals(textBoxPage.getResultCurrentAddress(), expectedResultCurrentAddress);
        String expectedResultPermanentAddress = excelReader.getStringData("TextBox", 2, 7);
        Assert.assertEquals(textBoxPage.getResultPermanentAddress(), expectedResultPermanentAddress);
    }

    @Description("Verify that a user fails to submit their data if they insert invalid format of email")
    @Test (groups = {"TextBox"})
    public void userFailsToSubmitDataInavlidFormatEmail() throws InterruptedException {
        sidePannelPage.clickOnTextBoxItem();
        textBoxPage.insertFullName(excelReader.getStringData("TextBox", 2, 0));
        textBoxPage.insertEmail(excelReader.getStringData("TextBox", 2, 8));
        textBoxPage.insertCurrentAddress(excelReader.getStringData("TextBox", 2, 2));
        textBoxPage.insertPermanentAddress(excelReader.getStringData("TextBox", 2, 3));
        textBoxPage.clickOnSubmitButton();
        Assert.assertFalse(textBoxPage.presenceOfOutputBox());
        String expectedErrorColourBorderEmailField = "rgba(255, 0, 0, 1)";
        Assert.assertEquals(textBoxPage.getErrorColourBorderEmailField(), expectedErrorColourBorderEmailField);
    }

    @Description("Verify that a user can select a file in the subfolder")
    @Test (groups = {"CheckBox"})
    public void userCanSelectOneFile() {
        sidePannelPage.clickOnCheckBoxItem();
        //String expectedColourOfHomeFolderBeforeExpansion = "rgba(51, 51, 204, 1)";
        //Assert.assertEquals(checkBoxPage.getColourFromHomeFolderBeforeExpansion(), expectedColourOfHomeFolderBeforeExpansion);
        //System.out.println(checkBoxPage.getColourFromHomeFolderBeforeExpansion());
        checkBoxPage.expandHomeFolder();
        checkBoxPage.expandDesktopFolder();
        checkBoxPage.checkNotesFiles();
        String expectedResultMessage = "You have selected :\n" + "notes";
        Assert.assertEquals(checkBoxPage.actualResultMessage(), expectedResultMessage);
    }

    @Description("Verify that a user can select all files within subfolder if they click on the check box next to that subfolder")
    @Test (groups = {"CheckBox"})
    public void userCanSelectAllFilesWithinSubfolder(){
        sidePannelPage.clickOnCheckBoxItem();
        checkBoxPage.expandHomeFolder();
        checkBoxPage.expandDesktopFolder();
        checkBoxPage.checkDesktopFolder();
        String expectedResultMessage = "You have selected :\n" + "desktop\n" + "notes\n" + "commands";
        Assert.assertEquals(checkBoxPage.actualResultMessage(), expectedResultMessage);
    }

    @Description("Verify that a user can select \"Yes\" and \"Impressive\" radio buttons")
    @Test (groups = {"RadioButton"})
    public void userCanSelectYesAndImpressiveRadioButtons() {
        sidePannelPage.clickOnRadioButtonItem();
        radioButtonsPage.clickOnYesRadioButton();
        Assert.assertTrue(radioButtonsPage.yesRadioButtonIsSelected());
        String expectedYesMessage = "Yes";
        Assert.assertEquals(radioButtonsPage.actualYesMessage(), expectedYesMessage);
        radioButtonsPage.clickOnImpressiveRadioButton();
        Assert.assertTrue(radioButtonsPage.impressiveRadioButtonIsSelected());
        String expectedImpressiveMessage = "Impressive";
        Assert.assertEquals(radioButtonsPage.actualImpressiveMessage(), expectedImpressiveMessage);
    }

    @Description("Verify that a user cannot select disabled \"No\" radio button")
    @Test (groups = {"RadioButton"})
    public void userCannotSelectNoRadioButton() {
        sidePannelPage.clickOnRadioButtonItem();
        Assert.assertFalse(radioButtonsPage.noRadioButtonIsEnabled());
    }

    @Description("Verify that a user can search employees in the Web Table by their first name")
    @Test (groups = {"WebTables"})
    public void userCanSearchEmployeesByFirstName() {
        sidePannelPage.clickOnWebTablesItem();
        String firstName = "Alden";
        webTablesPage.insertFirstNameInSearchBox(firstName);
        //System.out.println(webTablesPage.searchFirstNameInColumn(firstName));
        Assert.assertEquals(webTablesPage.searchFirstNameInColumn(firstName), firstName);
    }

    @Description("Verify that a user can remove an employee from the web table")
    @Test (groups = {"WebTables"})
    public void userCanDeleteEmployee(){
        sidePannelPage.clickOnWebTablesItem();
        webTablesPage.deleteEmployeeFromWebTable("Alden", "Cantrell", "45", "alden@example.com", "12000", "Compliance", 2);
        Assert.assertFalse(webTablesPage.isEmployeeInTheWebTable("Alden", "Cantrell", "45", "alden@example.com", "12000", "Compliance"));
        //System.out.println("delete-record-" + 2);

    }

    @Description("Verify that a user can perform double click")
    @Test (groups = {"Buttons"})
    public void doubleClick() {
        sidePannelPage.clickOnButtonsItem();
        buttonsPage.doubleClickOnDoubleClickMeButton();
        String expectedDoubleClickMeMessage = "You have done a double click";
        Assert.assertEquals(buttonsPage.actualDoubleClickMeMessage(), expectedDoubleClickMeMessage);
    }

    @Description("Verify that a user can perform right click")
    @Test (groups = {"Buttons"})
    public void rightClickTest() {
        sidePannelPage.clickOnButtonsItem();
        buttonsPage.rightClickOnRightClickMeButton();
        String expectedRightClickMeMessage = "You have done a right click";
        Assert.assertEquals(buttonsPage.actualRightClickMeMessage(), expectedRightClickMeMessage);
    }

    @Description("Verify that a user can perform single click")
    @Test (groups = {"Buttons"})
    public void singleClickTest() {
        sidePannelPage.clickOnButtonsItem();
        buttonsPage.ClickOnClickMeButton();
        String expectedClickMeMessage = "You have done a dynamic click";
        Assert.assertEquals(buttonsPage.actualClickMeMessage(), expectedClickMeMessage);
    }



}
