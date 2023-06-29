package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BasePage {

    public static WebDriver driver;
    public static ChromeOptions options;
    public static JavascriptExecutor js;
    public static WebDriverWait wdWait;
    public ExcelReader excelReader;
    public String homeURL;

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        //options.addArguments("load-extension=C:\\Users\\HP\\Desktop\\1.50.0_0");
        options.addArguments("load-extension=" + System.getProperty("user.dir") + "\\src\\test\\resources\\1.50.0_0");
        driver = new ChromeDriver(options);
        Thread.sleep(2000);
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
        wdWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        excelReader = new ExcelReader("src/test/resources/TestData.xlsx");
        homeURL = excelReader.getStringData("URL", 1, 0);
    }

    public void scrollIntoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForURL(String URL) {
        wdWait.until(ExpectedConditions.urlToBe(URL));
    }

    public void waitForVisibility(WebElement element) {
        wdWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element) {
        wdWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean elementIsPresent(WebElement element) {
        boolean present = false;
        try {
            present = element.isDisplayed();
        } catch (Exception e) {
        }
        return present;
    }

    public void openNewTab() {
        js.executeScript("window.open()");
    }

    public void saveImage(WebElement element) throws IOException {
        wdWait.until(ExpectedConditions.attributeContains(element, "src", "imgflip.com"));
        String link = element.getAttribute("src");
        URL imageURL = new URL(link);
        BufferedImage saveImage = ImageIO.read(imageURL);
        String location = "C:\\Users\\HP\\Desktop\\";
        ImageIO.write(saveImage, "png", new File(location + System.currentTimeMillis() + ".png"));
    }

    public String getCssValueFromElement(WebElement element, String property) {
        return element.getCssValue(property);
    }

    public void clickOnButton(WebElement element) {
        Actions action = new Actions(driver);
        action.click(element).perform();
    }

    public void clickOnButtonWithJS(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    public void doubleClick(WebElement element) {
        Actions action = new Actions(driver);
        action.doubleClick(element).perform();
    }


    public void rightClick(WebElement element) {
        Actions action = new Actions(driver);
        action.contextClick(element).perform();
    }

    public void hideElement(WebElement element)
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility='hidden'", element);
    }

    public void hideElements(List<WebElement> elements) {
        for (WebElement element : elements) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='hidden'", element);
        }
    }

    public void removeElements(List<WebElement> elements) {
        for (WebElement element : elements) {
            ((JavascriptExecutor) driver).executeScript("const element = document.getElementById(\"google_image_div\"); element.remove();", element);
        }
    }

    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    public boolean elementIsSelected(WebElement element) {
        boolean selected = false;
        try {
            selected = element.isSelected();
        } catch (Exception e) {
        }
        return selected;
    }

    public boolean elementIsEnabled(WebElement element) {
        boolean enabled = false;
        try {
            enabled = element.isEnabled();
        } catch (Exception e) {
        }
        return enabled;
    }

    public void closeSimpleAlert() {
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
    }

    public void closeSimpleAlertWithAssertion(String expectedMessage) throws InterruptedException {
        Thread.sleep(2000);
        Alert simpleAlert = driver.switchTo().alert();
        Assert.assertEquals(simpleAlert.getText(), expectedMessage);
        simpleAlert.accept();
    }

    public void hoverElement (WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
