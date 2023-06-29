package tests;

import base.BasePage;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class TestWidgets extends BasePage {

    HomePage homePage;
    SidePannelPage sidePannelPage;
    DatePickerPage datePickerPage;
    SliderPage sliderPage;
    ProgressBarPage progressBarPage;
    ToolTipsPage toolTipsPage;

    @BeforeMethod
    public void startSession(){
        homePage = new HomePage();
        sidePannelPage = new SidePannelPage();
        datePickerPage = new DatePickerPage();
        sliderPage = new SliderPage();
        progressBarPage = new ProgressBarPage();
        toolTipsPage = new ToolTipsPage();
        driver.get(homeURL);
        homePage.clickOnWidgetsCardButton();
    }

    @Description("Verify that a user can set a date of their birth")
    @Test
    public void userCanSetDate() {
        sidePannelPage.clickOnDatePickerItem();
        datePickerPage.clickOnDatePickerField();
        //datePickerPage.selectMonth();
        //datePickerPage.selectYear();
        datePickerPage.selectDate(2, 12, 1986);
    }

    @Description("Verify that a user can move slider to 75%")
    @Test
    public void userCanMoveSlider() {
        sidePannelPage.clickOnSliderItem();
        //System.out.println(sliderPage.getSliderValue());
        sliderPage.increaseSliderValue(25);
    }

    @Description("Verify that a user can stop progress bar")
    @Test
    public void userCanStopProgressBar() {
        sidePannelPage.clickOnProgressBarItem();
        String progressStopAt = "45";
        progressBarPage.startStopProgressBar(progressStopAt);
        String expectedProgressResult = progressStopAt + "%";
        Assert.assertEquals(progressBarPage.getProgress(), expectedProgressResult);
    }

    @Description("Verify that a user can reset progress bar after progress reaches 100%")
    @Test
    public void userCanResetProgressBar() throws InterruptedException {
        sidePannelPage.clickOnProgressBarItem();
        progressBarPage.resetProgressBar();
        Thread.sleep(2000);
        Assert.assertFalse(progressBarPage.progressIsPresent());
        Assert.assertTrue(progressBarPage.startButtonIsPresent());
    }

    @Description("Verify that a user can see hover message when they hover button ")
    @Test
    public void hoverButtonTest() {
        sidePannelPage.clickOnToolTipsItem();
        toolTipsPage.hoverToolTipButton();
        String expectedToolTipButtonHoverMessage = "Hover me to see";
        Assert.assertEquals(toolTipsPage.getToolTipButtonHoverMessage(), expectedToolTipButtonHoverMessage);
    }



}
