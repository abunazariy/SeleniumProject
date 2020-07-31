package test.day08_Alerts_Iframes_Windows;

import Utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Alerts_Practices {
    WebDriver driver;

    @BeforeClass
    public void seUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown()throws Exception{
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void InformationAlert(){
        WebElement infoAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        infoAlertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement successMessage = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(successMessage.isDisplayed());
    }

    @Test
    public void ConfirmationAlert(){
        WebElement confirmationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmationAlertButton.click();
        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.accept();
        String expectedMessage = "You clicked: Ok";
        String actualMessage = driver.findElement(By.xpath("//p[.='You clicked: Ok']")).getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void PromptAlert(){
        WebElement promptAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        promptAlertButton.click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Hello!");
        promptAlert.accept();
        String expectedPromptMessage = "You entered: Hello!";
        String actualPromptMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(actualPromptMessage,expectedPromptMessage);
    }

}

