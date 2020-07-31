package test.day06_TestNG_Dropdowns;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Dropdowns_Intro{
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void Test1(){
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        String actualDefaultOfSimpleDropdown= simpleDropdown.getFirstSelectedOption().getText();
        String expectedDefaultOfSimpleDropdown = "Please select an option";
        Assert.assertEquals(actualDefaultOfSimpleDropdown, expectedDefaultOfSimpleDropdown);

        Select stateSelection = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        String actualDefaultOfStateSelection = stateSelection.getFirstSelectedOption().getText();
        String expectedDefaultOfStateSelection = "Select a State";
        Assert.assertEquals(actualDefaultOfStateSelection, expectedDefaultOfStateSelection);

    }
    @Test
    public void Test2(){
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        stateDropdown.selectByValue("IL");
        stateDropdown.selectByVisibleText("Virginia");
        stateDropdown.selectByIndex(5);
        String actualFinalSelect = stateDropdown.getFirstSelectedOption().getText();
        String expectedFinalSelect = "California";
        Assert.assertEquals(actualFinalSelect, expectedFinalSelect);

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
