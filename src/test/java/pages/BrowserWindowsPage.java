package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class BrowserWindowsPage extends BasePage {

    public BrowserWindowsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "tabButton")
    WebElement newTabButton;

    @FindBy (id = "windowButton")
    WebElement newWindowButton;

    @FindBy (id = "messageWindowButton")
    WebElement newWindowMessageButton;

    @FindBy (id = "sampleHeading")
    WebElement sampleHeading;

    @FindBy (xpath = "/html/body")
    WebElement message;

    public void clickOnNewTabButton() {
        newTabButton.click();
    }

    public void navigateToNewTab(int index) {
        ArrayList<String> listOfTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listOfTabs.get(index));
    }

    public String actualSampleHeading(){
        return sampleHeading.getText();
    }

    public void clickOnNewWindowButton() {
        newWindowButton.click();
    }

    public void switchToTheNewWindow() {
        Set<String> handles = driver.getWindowHandles();
        String originalWindow = driver.getWindowHandle();

        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            String newWindow = iterator.next();
            if (!originalWindow.equalsIgnoreCase(newWindow))
                driver.switchTo().window(newWindow);
        }
    }

    public void clickOnNewWindowMessageButton() {
        newWindowMessageButton.click();
    }

    public String actualMessage() {
        return message.getText();
    }


}
