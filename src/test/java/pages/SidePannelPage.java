package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SidePannelPage extends BasePage {

    public SidePannelPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = ".btn.btn-light ")
    List<WebElement> elementsButtons;

    public void clickOnTextBoxItem() {
        for (WebElement element : elementsButtons) {
            if (element.getText().equals("Text Box")) {
                element.click();
                break;

            }
        }
    }

    public void clickOnCheckBoxItem() {
        for (WebElement element : elementsButtons) {
            if (element.getText().equals("Check Box")) {
                element.click();
                break;

            }
        }
    }

    public void clickOnRadioButtonItem() {
        for (WebElement element : elementsButtons) {
            if (element.getText().equals("Radio Button")) {
                element.click();
                break;
            }
        }
    }

    public void clickOnWebTablesItem() {
        for (WebElement element : elementsButtons) {
            if (element.getText().equals("Web Tables")) {
                element.click();
                break;
            }
        }
    }

    public void clickOnButtonsItem() {
        for (WebElement element : elementsButtons) {
            if (element.getText().equals("Buttons")) {
                element.click();
                break;
            }
        }
    }

    public void clickOnBrowserWindowsItem() {
        for (WebElement element : elementsButtons) {
            if (element.getText().equals("Browser Windows")) {
                element.click();
                break;
            }
        }
    }

    public void clickOnAlertsItem() {
        for (WebElement element : elementsButtons) {
            if (element.getText().equals("Alerts")) {
                element.click();
                break;
            }
        }
    }

    public void clickOnDatePickerItem() {
            for (WebElement element : elementsButtons) {
               if (element.getText().equals("Date Picker")) {
                    element.click();
                    break;
               }
            }
    }

    public void clickOnSliderItem() {
        for (WebElement element : elementsButtons) {
            if (element.getText().equals("Slider")) {
                element.click();
                break;
            }
        }
    }

    public void clickOnProgressBarItem() {
        for (WebElement element : elementsButtons) {
            if (element.getText().equals("Progress Bar")) {
                scrollIntoView(element);
                element.click();
                break;
            }
        }
    }

    public void clickOnToolTipsItem() {
        for (WebElement element : elementsButtons) {
            if (element.getText().equals("Tool Tips")) {
                scrollIntoView(element);
                element.click();
                break;
            }
        }
    }

    public void clickOnLoginItem() {
        for (WebElement element : elementsButtons) {
            if (element.getText().equals("Login")) {
                element.click();
                break;
            }
        }
    }

    public void clickOnBookStoreItem() {
        for (WebElement element : elementsButtons) {
            if (element.getText().equals("Book Store")) {
                scrollIntoView(element);
                element.click();
                break;
            }
        }
    }

    public void clickOnProfileItem() {
        for (WebElement element : elementsButtons) {
            if (element.getText().equals("Profile")) {
                scrollIntoView(element);
                element.click();
                break;
            }
        }
    }




}
