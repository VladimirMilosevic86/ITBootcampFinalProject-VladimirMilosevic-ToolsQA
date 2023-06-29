package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DatePickerPage extends BasePage {

    public DatePickerPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "datePickerMonthYearInput")
    WebElement datePicker;

    @FindBy (css = "react-datepicker__week")
    WebElement da;

    @FindBy (className = "react-datepicker__month-select")
    WebElement month;

    @FindBy (className = "react-datepicker__year-select")
    WebElement year;

    public void clickOnDatePickerField() {
        datePicker.click();
    }

    /*public void selectMonth() {
        Select select = new Select(month);
        select.selectByValue("1"); //February
    }

    public void selectYear() {
        Select select = new Select(year);
        select.selectByValue("1986");
    }*/

    public void selectDate(int mm, int dd, int y) {
        //this will select month
        Select selectMonth = new Select(month);
        int monthValue = mm - 1;
        selectMonth.selectByValue(Integer.toString(monthValue));

        //this will select year
        Select selectYear = new Select(year);
        selectYear.selectByValue(Integer.toString(y));

        //this will select day
        WebElement day = driver.findElement(By.cssSelector(".react-datepicker__day.react-datepicker__day--0" + dd));
        day.click();
    }

    // xpath -->   //div[@aria-label='Choose Sunday, February 12th, 2023']  String DD, String YY

    // css ako dan pada na vikend -->   .react-datepicker__day.react-datepicker__day--012.react-datepicker__day--weekend

    // css ako dan pada na radni dan -->   .react-datepicker__day.react-datepicker__day--0" + dd




}
