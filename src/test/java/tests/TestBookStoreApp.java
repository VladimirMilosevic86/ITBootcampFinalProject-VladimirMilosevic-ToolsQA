package tests;

import base.BasePage;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class TestBookStoreApp extends BasePage {

    HomePage homePage;
    MainHeaderPage mainHeaderPage;
    SidePannelPage sidePannelPage;
    LoginPage loginPage;
    BookStorePage bookStorePage;
    ProfilePage profilePage;


    @BeforeMethod
    public void startSession(){
        homePage = new HomePage();
        mainHeaderPage = new MainHeaderPage();
        sidePannelPage = new SidePannelPage();
        loginPage = new LoginPage();
        bookStorePage = new BookStorePage();
        profilePage = new ProfilePage();
        driver.get(homeURL);
        homePage.clickOnBookStoreApplicationCardButton();
    }


    @Description("Verify that an user can log in successfully if they insert valid credentials")
    @Test (groups = {"Login"})
    public void userCanLogIn() throws InterruptedException {
        sidePannelPage.clickOnLoginItem();
        String validUsername = excelReader.getStringData("LoginForm", 2, 0);
        String validPassword = excelReader.getStringData("LoginForm", 2, 1);
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        loginPage.clickOnLoginButton();
        String expectedURL = excelReader.getStringData("URL", 1, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        String expectedPageName = "Profile";
        Assert.assertEquals(mainHeaderPage.getPageName(), expectedPageName);
        Assert.assertTrue(profilePage.presenceOfDisplayedUsername());
        Assert.assertEquals(profilePage.getDisplayedUsername(), validUsername);
        Assert.assertTrue(profilePage.presenceOfLogOutButton());
    }

    @Description("Verify that an user cannot log in if they leave username and password fields empty")
    @Test (groups = {"Login"})
    public void userCannotLogInWithoutUsernameAndPassword() throws InterruptedException {
        sidePannelPage.clickOnLoginItem();
        loginPage.clickOnLoginButton();
        String expectedURL = excelReader.getStringData("URL", 1, 1);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        String expectedErrorColourUsernameAndPasswordFieldBorder = "rgb(220, 53, 69)";
        Assert.assertEquals(loginPage.getColourFromUsernameFieldBorder(), expectedErrorColourUsernameAndPasswordFieldBorder);
        Assert.assertEquals(loginPage.getColourFromPasswordFieldBorder(), expectedErrorColourUsernameAndPasswordFieldBorder);
        String expectedPageName = "Login";
        Assert.assertEquals(mainHeaderPage.getPageName(), expectedPageName);
        Assert.assertTrue(loginPage.presenceOfLoginButton());
    }

    @Description("Verify that an user cannot log in with invalid username and password")
    @Test (groups = {"Login"})
    public void userCannotLogInWithInvalidUsernameAndPassword() throws InterruptedException {
        sidePannelPage.clickOnLoginItem();
        String invalidUsername = excelReader.getStringData("LoginForm", 2, 2);
        String invalidPassword = excelReader.getStringData("LoginForm", 2, 3);
        loginPage.insertUsername(invalidUsername);
        loginPage.insertPassword(invalidPassword);
        loginPage.clickOnLoginButton();
        String expectedUnsuccessfulLoginMessage = "Invalid username or password!";
        Assert.assertEquals(loginPage.getUnsuccessfulLoginMessage(), expectedUnsuccessfulLoginMessage);
        String expectedPageName = "Login";
        Assert.assertEquals(mainHeaderPage.getPageName(), expectedPageName);
        Assert.assertTrue(loginPage.presenceOfLoginButton());
    }

    @Description("Verify that an user can add one book from the Book Store")
    @Test (groups = {"BookStore"})
    public void userCanAddOneBook() throws InterruptedException {
        userCanLogIn();
        sidePannelPage.clickOnBookStoreItem();
        bookStorePage.addGitPocketGuideBook();
        bookStorePage.clickOnAddToYourCollectionButton();
        Thread.sleep(2000);
        closeSimpleAlert();
        sidePannelPage.clickOnProfileItem();
        Thread.sleep(2000);
        Assert.assertTrue(profilePage.presenceOfBookByTitle("Git Pocket Guide"));
        profilePage.clickOnDeleteAllBooksWhileOnProfile();
        profilePage.confirmDeletionOfAllBooks();
        Thread.sleep(2000);
        closeSimpleAlert();
    }

    @Description("Verify that an user can delete all books from their profile")
    @Test (groups = {"BookStore"})
    public void userCanDeleteAllBooks() throws InterruptedException {
        userCanLogIn();
        sidePannelPage.clickOnBookStoreItem();
        bookStorePage.addGitPocketGuideBook();
        bookStorePage.clickOnAddToYourCollectionButton();
        Thread.sleep(2000);
        closeSimpleAlert();
        sidePannelPage.clickOnProfileItem();
        Thread.sleep(2000);
        profilePage.clickOnDeleteAllBooksWhileOnProfile();
        profilePage.confirmDeletionOfAllBooks();
        String expectedMessage = "All Books deleted.";
        closeSimpleAlertWithAssertion(expectedMessage);
        Thread.sleep(2000);
        Assert.assertFalse(profilePage.presenceOfBookByTitle("Git Pocket Guide"));
    }

    @Description("Verify that an user can delete all books from their profile")
    @Test (groups = {"BookStore"})
    public void userCannotAddSameBookTwice() throws InterruptedException {
        userCanLogIn();
        sidePannelPage.clickOnBookStoreItem();
        bookStorePage.addGitPocketGuideBook();
        bookStorePage.clickOnAddToYourCollectionButton();
        Thread.sleep(2000);
        closeSimpleAlert();
        bookStorePage.clickOnBackToBookStoreButton();
        bookStorePage.addGitPocketGuideBook();
        bookStorePage.clickOnAddToYourCollectionButton();
        String expectedMessage = "Book already present in the your collection!";
        closeSimpleAlertWithAssertion(expectedMessage);
        profilePage.clickOnDeleteAllBooksWhileOnProfile();
        profilePage.confirmDeletionOfAllBooks();
        Thread.sleep(2000);
        closeSimpleAlert();
    }

}
