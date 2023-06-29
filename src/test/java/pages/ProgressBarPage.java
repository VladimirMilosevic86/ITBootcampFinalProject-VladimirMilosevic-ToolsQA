package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ProgressBarPage extends BasePage {

    public ProgressBarPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "progressBar")
    WebElement progressBar;

    @FindBy (id = "startStopButton")
    WebElement startStopButton;

    @FindBy (id = "resetButton")
    WebElement resetButton;

    @FindBy (css = ".progress-bar.bg-info")
    WebElement progress;

    @FindBy (css = ".progress-bar.bg-success")
    WebElement progressFinished;

    public void startStopProgressBar(String stopAtPercentage) {
        scrollIntoView(progressBar);
        startStopButton.click();
        wdWait.pollingEvery(Duration.ofMillis(100));
        wdWait.until(ExpectedConditions.attributeToBe(progress, "aria-valuenow", stopAtPercentage));
        startStopButton.click();
    }

    public void resetProgressBar() {
        scrollIntoView(progressBar);
        startStopButton.click();
        wdWait.pollingEvery(Duration.ofMillis(100));
        wdWait.until(ExpectedConditions.attributeToBe(By.cssSelector("button[class='mt-3 btn btn-primary']"), "id", "resetButton"));
        if (progressFinished.getText().equals("100%"))
            resetButton.click();
    }

    public String getProgress() {
        return progress.getText();
    }

    public boolean progressIsPresent() {
        return progress.isDisplayed();
    }

    public  boolean startButtonIsPresent() {
        return startStopButton.isDisplayed();
    }

}
