package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = ".card.mt-4.top-card")
    List<WebElement> cardButtons;

    public void clickOnElementsCardButton(){
        for (WebElement card : cardButtons) {
            if (card.getText().equals("Elements")) {
                card.click();
                break;
            }
        }
    }

    public void clickOnAlertsFrameAndWindowsCardButton(){
        for (WebElement card : cardButtons) {
            if (card.getText().equals("Alerts, Frame & Windows")) {
                card.click();
                break;
            }
        }
    }

    public void clickOnWidgetsCardButton(){
        for (WebElement card : cardButtons) {
            if (card.getText().equals("Widgets")) {
                card.click();
                break;
            }
        }
    }

    public void clickOnBookStoreApplicationCardButton(){
        for (WebElement cardButton : cardButtons) {
            if (cardButton.getText().equals("Book Store Application")) {
                scrollIntoView(cardButton);
                cardButton.click();
            }
        }
    }

}
