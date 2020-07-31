package test.VyTrack;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VyTrack_01 {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown()throws Exception{
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void Test1(){
        WebElement usernameInput = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        usernameInput.sendKeys("user31");
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordInput.sendKeys("UserUser123");
        WebElement logInButton = driver.findElement(By.xpath("//button[@id='_submit']"));
        logInButton.click();
        WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleet.click();


    }


}
