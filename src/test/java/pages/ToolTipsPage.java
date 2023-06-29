package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolTipsPage extends BasePage {

    public ToolTipsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "toolTipButton")
    WebElement toolTipButton;

    public void hoverToolTipButton() {
        hoverElement(toolTipButton);
    }

    public String getToolTipButtonHoverMessage() {
        return toolTipButton.getText();
    }

}
