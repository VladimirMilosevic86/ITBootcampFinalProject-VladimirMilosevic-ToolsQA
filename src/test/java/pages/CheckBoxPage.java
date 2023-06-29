package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage extends BasePage {

    public CheckBoxPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//*[@id=\"tree-node\"]/ol/li/span/button")
    WebElement arrowHomeFolder;

    /*@FindBy (xpath = "//*[@id=\"tree-node\"]/ol/li/span/label/span[2]")
    WebElement homeFolder;*/

    @FindBy (xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button")
    WebElement arrowDesktopFolder;

    @FindBy (xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[1]/span/label/span[1]")
    WebElement checkBoxNotesFile;

    @FindBy (xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/label/span[1]")
    WebElement checkBoxDesktopFolder;

    @FindBy (id = "result")
    WebElement resultMessage;

    /*public String getColourFromHomeFolderBeforeExpansion() {
        return getColourFromElement(homeFolder, "color");
    }     */

    public void expandHomeFolder () {
        arrowHomeFolder.click();
    }

    public void expandDesktopFolder() {
        arrowDesktopFolder.click();
    }

    public void checkNotesFiles() {
        checkBoxNotesFile.click();
    }

    public void checkDesktopFolder(){
        checkBoxDesktopFolder.click();
    }

    public String actualResultMessage() {
        return getTextFromElement(resultMessage);
    }




}
