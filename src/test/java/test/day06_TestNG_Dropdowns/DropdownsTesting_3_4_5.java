package test.day06_TestNG_Dropdowns;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownsTesting_3_4_5 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void Test3() throws Exception{
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        selectYear.selectByVisibleText("1921");
        String actualSelectedYear = selectYear.getFirstSelectedOption().getText();
        String expectedSelectedYear = "1921";
        Assert.assertEquals(actualSelectedYear, expectedSelectedYear);
        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        selectMonth.selectByValue("11");
        String actualSelectedMonth = selectMonth.getFirstSelectedOption().getText();
        String expectedSelectedMonth = "December";
        Assert.assertEquals(actualSelectedMonth, expectedSelectedMonth);
        Select selectDay = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        selectDay.selectByIndex(0);
        String actualSelectedDay = selectDay.getFirstSelectedOption().getText();
        String expectedSelectedDay = "1";
        Assert.assertEquals(actualSelectedDay, expectedSelectedDay);
        Thread.sleep(2000);
    }

    @Test
    public void Test4()throws Exception{
        Select languagesDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        List<WebElement> allOptions = languagesDropdown.getOptions();

        for (WebElement Option: allOptions){
            Option.click();
            System.out.println(Option.getText());

            Assert.assertTrue(Option.isSelected());
        }
        languagesDropdown.deselectAll();

        for (WebElement Option2: allOptions){
            Assert.assertFalse(Option2.isSelected());
        }
        Thread.sleep(2000);
    }

    @Test
    public void Test5()throws Exception{
        WebElement nonSelectDropdown = driver.findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']"));
        nonSelectDropdown.click();
        Thread.sleep(2000);
        WebElement facebookLink = driver.findElement(By.linkText("Facebook"));
        facebookLink.click();
        Thread.sleep(2000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";
        Thread.sleep(2000);
        Assert.assertEquals(actualTitle,expectedTitle);

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
