package pages;

import base.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AlertsPage extends BasePage {

    public AlertsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "alertButton")
    WebElement clickMeButton;

    @FindBy (id = "timerAlertButton")
    WebElement timerClickMeButton;

    @FindBy (id = "confirmButton")
    WebElement confirmClickMeButton;

    @FindBy (id = "confirmResult")
    WebElement confirmMessage;

    @FindBy (id = "promtButton")
    WebElement promptClickMeButton;

    @FindBy (id = "promptResult")
    WebElement promptMessage;

    public void clickOnClickMeButton() {
        clickMeButton.click();
    }

    public void closeSimpleAlertWithAssertion() {
        Alert simpleAlert = driver.switchTo().alert();
        String expectedMessage = "You clicked a button";
        Assert.assertEquals(simpleAlert.getText(), expectedMessage);
        simpleAlert.accept();
    }

    public void clickOnTimerClickMeButton() throws InterruptedException {
        timerClickMeButton.click();
        Thread.sleep(5500);
    }

    public void closeTimerAlertWithAssertion() {
        Alert simpleAlert = driver.switchTo().alert();
        String expectedMessage = "This alert appeared after 5 seconds";
        Assert.assertEquals(simpleAlert.getText(), expectedMessage);
        simpleAlert.accept();
    }

    public void clickOnConfirmButton() {
        confirmClickMeButton.click();
    }

    public void cancelConfirmationAlert() {
        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.dismiss();
    }

    public String actualConfirmationMessage() {
        return confirmMessage.getText();
    }

    public void clickOnPromptClickMeButton() {
        promptClickMeButton.click();
    }

    public void insertNameInPromptBox(String name) {
        Alert promptBox = driver.switchTo().alert();
        promptBox.sendKeys(name);
        promptBox.accept();
    }

    public String actualPromptMessage() {
        return promptMessage.getText();
    }

}
