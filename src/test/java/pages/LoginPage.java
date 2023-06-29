package pages;

import base.BasePage;
import com.google.auto.common.Visibility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "newUser")
    WebElement newUserButton;

    @FindBy (id = "userName")
    WebElement usernameField;

    @FindBy (id = "password")
    WebElement passwordField;

    @FindBy (id = "login")
    WebElement loginButton;

    @FindBy (id = "name")
    WebElement unsuccessfulLoginMessage;

    public void clickOnNewUserButton() {
        newUserButton.click();
    }

    public void insertUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void insertPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() throws InterruptedException {
        loginButton.click();
        Thread.sleep(500);
    }

    public boolean presenceOfLoginButton() {
        return elementIsPresent(loginButton);
    }

    public String getColourFromUsernameFieldBorder() {
        return getCssValueFromElement(usernameField, "border-color");
    }

    public String getColourFromPasswordFieldBorder() {
        return getCssValueFromElement(passwordField, "border-color");
    }

    public String getUnsuccessfulLoginMessage() {
        return getTextFromElement(unsuccessfulLoginMessage);
    }

}
