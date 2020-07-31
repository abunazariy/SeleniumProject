package test.day08_Alerts_Iframes_Windows;

import Utilities.SmartBearUtilities;
import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Practice_09_10_11 {
    WebDriver driver;

    @BeforeClass
    public void seUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        SmartBearUtilities.login(driver);
    }

    @AfterClass
    public void tearDown()throws Exception{
        Thread.sleep(2000);
        //driver.close();
    }

    @Test
    public void Test9(){
        WebElement markSmithCheckButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl03_OrderSelector']"));
        markSmithCheckButton.click();
        WebElement deleteButton = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$btnDelete']"));
        deleteButton.click();

        List<WebElement> listOfNames = driver.findElements(By.xpath("//table[@class='SampleTable']//td[2]"));

        for (WebElement eachName: listOfNames){
            Assert.assertFalse(eachName.getText().equals("Mark Smith"));
        }
    }

    @Test
    public void Test10(){
        WebElement editButtonSteveJohns = driver.findElement(By.xpath("(//input[@type='image'])[3]"));
        editButtonSteveJohns.click();
        WebElement spaceForName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        spaceForName.click();
        spaceForName.clear();
        spaceForName.sendKeys("Michael Jordan");
        WebElement updateButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_UpdateButton']"));
        updateButton.click();
        List<WebElement> listOfNames = driver.findElements(By.xpath("//table[@class='SampleTable']//td[2]"));

        for (WebElement eachName: listOfNames){
            if (eachName.getText().equals("Michael Jordan")){
                Assert.assertTrue(true);
                return;

            }
        }
        Assert.fail();


    }

    @Test
    public void Test11(){

        SmartBearUtilities.removeName(driver,"Bob Feather");
    }
}
