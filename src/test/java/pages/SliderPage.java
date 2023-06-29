package pages;

import base.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SliderPage extends BasePage {

    public SliderPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = ".range-slider.range-slider--primary")
    WebElement slider;

    public void increaseSliderValue(int slideValue) {
        for (int i = 1; i <= slideValue ; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }
    public void decreaseSliderValue(int slideValue) {
        for (int i = 1; i <= slideValue; i++) {
            slider.sendKeys(Keys.ARROW_LEFT);
        }
    }

    public void getSliderSize() {
        int size = slider.getSize().width;
        System.out.println(size);
    }

    public void moveSlider(int percent) {
        double position = percent * 0.2;
        Actions action = new Actions(driver);
        action.clickAndHold(slider);
        action.moveByOffset((int)position, 0).build().perform();
    }

   /* WebElement slider = driver.FindElement(By.XPath(".//*[@id='mcl-range__nutrition.dietaryFiber']"));
    int slidersizewidth = slider.Size.Width;//640
    Actions action = new Actions(driver);
action.ClickAndHold(slider);
action.MoveByOffset(40, 0).Build().Perform();*/

}
