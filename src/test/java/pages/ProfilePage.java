package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProfilePage extends BasePage {

    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "userName-value")
    WebElement displayedUsername;

    @FindBy (css = ".btn.btn-primary")
    List<WebElement> buttons;

    @FindBy (className = "rt-td")
    List<WebElement> cells;

    @FindBy (className = "modal-content")
    WebElement modalDialog;

    @FindBy (id = "closeSmallModal-ok")
    WebElement okButtonSmallModal;

    public void clickOnDeleteAllBooksWhileOnProfile() {
        for (WebElement button : buttons) {
            if (button.getText().equals("Delete All Books"))
                button.click();
        }
    }

    public void confirmDeletionOfAllBooks() {
        waitForVisibility(modalDialog);
        okButtonSmallModal.click();
    }

    public String getDisplayedUsername() {
        return displayedUsername.getText();
    }

    public boolean presenceOfDisplayedUsername() {
        return elementIsPresent(displayedUsername);
    }

    public boolean presenceOfLogOutButton() {
        for (WebElement button : buttons) {
            if (button.getText().equals("Log out"))
                return button.isDisplayed();
            break;
        }
        return false;
    }

    public boolean presenceOfBookByTitle(String bookName) {
        for (int i = 1; i < cells.size(); i += 5) {
            if (cells.get(i).getText().equalsIgnoreCase(bookName))
                return true;
        }
        return false;
    }



}
