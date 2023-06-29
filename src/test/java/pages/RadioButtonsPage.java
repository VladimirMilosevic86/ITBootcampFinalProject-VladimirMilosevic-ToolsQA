package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RadioButtonsPage extends BasePage {

    public RadioButtonsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "yesRadio")
    WebElement yesRadioButton;

    @FindBy (className = "text-success")
    WebElement yesMessage;

    @FindBy (id = "impressiveRadio")
    WebElement impressiveRadioButton;

    @FindBy (className = "text-success")
    WebElement impressiveMessage;

    @FindBy (id = "noRadio")
    WebElement noRadioButton;

    @FindBy (id = "google_image_div")
    List<WebElement> ADs;

    public void clickOnYesRadioButton() {
        clickOnButton(yesRadioButton);
    }

    public boolean yesRadioButtonIsSelected() {
        return elementIsSelected(yesRadioButton);
    }

    public String actualYesMessage() {
        return getTextFromElement(yesMessage);
    }

    public void clickOnImpressiveRadioButton() {
        clickOnButtonWithJS(impressiveRadioButton);
    }

    public boolean impressiveRadioButtonIsSelected() {
        return elementIsSelected(impressiveRadioButton);
    }

    public String actualImpressiveMessage() {
        return getTextFromElement(impressiveMessage);
    }

    public boolean noRadioButtonIsEnabled() {
        return elementIsEnabled(noRadioButton);
    }

}
