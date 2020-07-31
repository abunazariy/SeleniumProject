package test.day07_JavaFaker_WebTables;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Practice_07_08 {

    WebDriver driver;

    @BeforeClass
    public void seUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown()throws Exception{
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void Test7(){
        Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        String actualMonth = month.getFirstSelectedOption().getText();
        String expectedMonth = LocalDate.now().getMonth().name();
        Assert.assertTrue(actualMonth.equalsIgnoreCase(expectedMonth));
    }

    @Test
    public void Test8(){
        Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        List <WebElement> listOfMonths = month.getOptions();
        List<String> expectedListOfMonths = new ArrayList<>(Arrays.asList("January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December"));
        List<String> actualListOfMonth = new ArrayList<>();
        for (WebElement eachMonth : listOfMonths) {
            actualListOfMonth.add(eachMonth.getText());
        }

        Assert.assertEquals(actualListOfMonth, expectedListOfMonths);

    }
}
