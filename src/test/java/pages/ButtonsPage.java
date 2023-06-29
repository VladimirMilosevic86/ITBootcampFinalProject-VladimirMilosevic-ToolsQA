package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ButtonsPage extends BasePage {

    public ButtonsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "doubleClickBtn")
    WebElement doubleClickMeButton;
    @FindBy (id = "doubleClickMessage")
    WebElement doubleClickMeMessage;
    @FindBy (id = "rightClickBtn")
    WebElement rightClickMeButton;
    @FindBy (id = "rightClickMessage")
    WebElement rightClickMessage;
    @FindBy (css = ".btn.btn-primary")
    List<WebElement> buttons;
    @FindBy(id = "dynamicClickMessage")
    WebElement clickMeMessage;

    public void doubleClickOnDoubleClickMeButton() {
        doubleClick(doubleClickMeButton);
    }

    public String actualDoubleClickMeMessage() {
        return getTextFromElement(doubleClickMeMessage);
    }

    public void rightClickOnRightClickMeButton() {
        rightClick(rightClickMeButton);
    }

    public String actualRightClickMeMessage() {
        return getTextFromElement(rightClickMessage);
    }

    public void ClickOnClickMeButton() {
        for (WebElement button : buttons) {
            if (button.getText().equals("Click Me")) {
                button.click();
                break;
            }
        }
    }

    public String actualClickMeMessage() {
        return getTextFromElement(clickMeMessage);
    }

}
