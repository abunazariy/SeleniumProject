package test.day06_TestNG_Dropdowns;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_SeleniumPractice {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void google_title_verification(){

        driver.get("https://www.google.com");
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
    @Test
    public void google_search_title_verification(){

        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Apple"+ Keys.ENTER);
        String actualTitle = driver.getTitle();
        String expectedInTitle = "Apple";
        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }

}
