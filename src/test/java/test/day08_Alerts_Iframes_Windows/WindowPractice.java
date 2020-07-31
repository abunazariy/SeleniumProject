package test.day08_Alerts_Iframes_Windows;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowPractice {

    WebDriver driver;

    @BeforeClass
    public void seUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/windows");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown()throws Exception{
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void Window()throws Exception{
        WebElement clickHereLink = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereLink.click();

        Set<String> windowHandles = driver.getWindowHandles();

        // switching 'New Window' titled tab
        for (String eachWindow: windowHandles ){
            driver.switchTo().window(eachWindow);
            if (driver.getTitle().equals("New Window")){
                Assert.assertTrue(true);
                break;
            }

        }
        Thread.sleep(2000);

        // switching 'Practice' titled tab
        for (String eachWindow: windowHandles ){
            driver.switchTo().window(eachWindow);
            if (driver.getTitle().equals("Practice")){
                Assert.assertTrue(true);
                break;
            }

        }
    }
}
