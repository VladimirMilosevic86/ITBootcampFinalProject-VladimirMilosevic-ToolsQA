package tests;

import base.BasePage;
import jdk.jfr.Description;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class TestAlertsFrameWindows extends BasePage {

    HomePage homePage;
    SidePannelPage sidePannelPage;
    BrowserWindowsPage browserWindowsPage;
    AlertsPage alertsPage;
    SliderPage sliderPage;

    @BeforeMethod
    public void startSession(){
        homePage = new HomePage();
        sidePannelPage = new SidePannelPage();
        browserWindowsPage = new BrowserWindowsPage();
        alertsPage = new AlertsPage();
        sliderPage = new SliderPage();
        driver.get(homeURL);
        homePage.clickOnAlertsFrameAndWindowsCardButton();
    }

    @Description("Verify that a user can see heading in the new tab")
    @Test (groups = {"BrowserWindows"})
    public void newTabTest() {
        sidePannelPage.clickOnBrowserWindowsItem();
        browserWindowsPage.clickOnNewTabButton();
        browserWindowsPage.navigateToNewTab(1);
        String expectedSampleHeading = "This is a sample page";
        Assert.assertEquals(browserWindowsPage.actualSampleHeading(), expectedSampleHeading);
    }

    @Description("Verify that a user can see heading in the new window")
    @Test (groups = {"BrowserWindows"})
    public void newWindowTest() {
        sidePannelPage.clickOnBrowserWindowsItem();
        browserWindowsPage.clickOnNewWindowButton();
        browserWindowsPage.switchToTheNewWindow();
        String expectedSampleHeading = "This is a sample page";
        Assert.assertEquals(browserWindowsPage.actualSampleHeading(), expectedSampleHeading);
    }

    /*@Description("Verify that a user can read the message from the new window that opens")
    @Test
    public void newWindowMessageTest() {
        sidePannelPage.clickOnBrowserWindowsItem();
        browserWindows.clickOnNewWindowMessageButton();
        browserWindows.switchToTheNewWindow();
        System.out.println(browserWindows.actualMessage());
    }*/

    @Description("Verify that a user can see alert after they click on \"Click Me\" button")
    @Test (groups = {"Alerts"})
    public void userCanSeeAlert() {
        sidePannelPage.clickOnAlertsItem();
        alertsPage.clickOnClickMeButton();
        alertsPage.closeSimpleAlertWithAssertion();
    }

    @Description("Verify that a user can see alert 5 seconds after they click on \"Click Me\" button")
    @Test (groups = {"Alerts"})
    public void userCanSeeAlertAfter5Sec() throws InterruptedException {
        sidePannelPage.clickOnAlertsItem();
        alertsPage.clickOnTimerClickMeButton();
        alertsPage.closeTimerAlertWithAssertion();
    }

    @Description("Verify that a user can cancel alert after they click on \"Click Me\" button")
    @Test (groups = {"Alerts"})
    public void userCanCancelAlert() {
        sidePannelPage.clickOnAlertsItem();
        alertsPage.clickOnConfirmButton();
        alertsPage.cancelConfirmationAlert();
        String expectedCancelConfirmationMessage = "You selected Cancel";
        Assert.assertEquals(alertsPage.actualConfirmationMessage(), expectedCancelConfirmationMessage);
    }

    @Description("Verify that a user can insert their name in prompt box after they click on \"Click Me\" button")
    @Test (groups = {"Alerts"})
    public void userCanInsertNameInPromptBox() {
        sidePannelPage.clickOnAlertsItem();
        alertsPage.clickOnPromptClickMeButton();
        String name = "Zivorad Veselinovic";
        alertsPage.insertNameInPromptBox(name);
        String expectedPromptMessage = "You entered " + name;
        Assert.assertEquals(alertsPage.actualPromptMessage(), expectedPromptMessage);
    }

}
