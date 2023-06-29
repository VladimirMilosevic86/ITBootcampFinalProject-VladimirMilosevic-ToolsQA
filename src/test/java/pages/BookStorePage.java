package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookStorePage extends BasePage {

    public BookStorePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "see-book-Git Pocket Guide")
    WebElement bookGitPocketGuide;

    @FindBy (css = ".text-right.fullButton")
    WebElement addToYourCollectionButton;

    @FindBy (css = ".text-left.fullButton")
    WebElement backToBookStoreButton;



    public void addGitPocketGuideBook() {
        waitForVisibility(bookGitPocketGuide);
        bookGitPocketGuide.click();
    }

    public void clickOnAddToYourCollectionButton() {
        waitForVisibility(addToYourCollectionButton);
        addToYourCollectionButton.click();
    }

    public void clickOnBackToBookStoreButton() {
        waitForVisibility(backToBookStoreButton);
        backToBookStoreButton.click();
    }



}
