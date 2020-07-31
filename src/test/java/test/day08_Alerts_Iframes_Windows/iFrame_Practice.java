package test.day08_Alerts_Iframes_Windows;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class iFrame_Practice {

    WebDriver driver;

    @BeforeClass
    public void seUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/iframe");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown()throws Exception{
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void iFrame(){
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);
        WebElement actualMessage = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        Assert.assertTrue(actualMessage.isDisplayed());
        driver.switchTo().defaultContent();
        WebElement tinyMCEText = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(tinyMCEText.isDisplayed());
    }
}
