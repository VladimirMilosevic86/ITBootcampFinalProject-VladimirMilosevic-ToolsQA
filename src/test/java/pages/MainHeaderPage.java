package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainHeaderPage extends BasePage {

    public MainHeaderPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "main-header")
    WebElement pageName;

    public String getPageName() {
        return pageName.getText();
    }

    public void scrollPageNameIntoView() {
        scrollIntoView(pageName);
    }
}
