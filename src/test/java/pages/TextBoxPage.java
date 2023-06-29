package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TextBoxPage extends BasePage {

    public TextBoxPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "userName")
    WebElement fullNameField;

    @FindBy (id = "userEmail")
    WebElement emailField;

    @FindBy (id = "currentAddress")
    List<WebElement> currentAddressField;

    @FindBy (id = "permanentAddress")
    List<WebElement> permanentAddressField;

    @FindBy (id = "submit")
    WebElement submitButton;

    @FindBy (id = "name")
    WebElement resultName;

    @FindBy (id = "email")
    WebElement resultEmail;
    @FindBy (id = "output")
    WebElement outputBox;

    public void insertFullName(String fullName) {
        fullNameField.sendKeys(fullName);
    }

    public void insertEmail(String email) {
        emailField.sendKeys(email);
    }

    public void insertCurrentAddress(String currentAddress) {
        for (int i = 0; i < currentAddressField.size(); i++) {
            currentAddressField.get(0).sendKeys(currentAddress);
        }
    }

    public void insertPermanentAddress(String permanentAddress) {
        for (int i = 0; i < permanentAddressField.size(); i++) {
            permanentAddressField.get(0).sendKeys(permanentAddress);
        }
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public String getResultFullName() {
        return resultName.getText();
    }

    public String getResultEmail() {
        return resultEmail.getText();
    }

    public String getResultCurrentAddress() {
        String resultCurrentAddress = "";
        for (int i = 0; i < currentAddressField.size(); i++) {
            resultCurrentAddress = currentAddressField.get(1).getText();
        }
        return resultCurrentAddress;
    }

    public String getResultPermanentAddress() {
        String resultPermanentAddress = "";
        for (int i = 0; i < permanentAddressField.size(); i++) {
            resultPermanentAddress = permanentAddressField.get(1).getText();
        }
        return resultPermanentAddress;
    }
    public boolean presenceOfOutputBox() {
        return elementIsPresent(outputBox);
    }

    public String getErrorColourBorderEmailField() throws InterruptedException {
        Thread.sleep(2000);
        return getCssValueFromElement(emailField, "border-bottom-color");
    }
}
