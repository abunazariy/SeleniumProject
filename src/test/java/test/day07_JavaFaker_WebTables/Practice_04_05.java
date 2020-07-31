package test.day07_JavaFaker_WebTables;

import Utilities.SmartBearUtilities;
import Utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Practice_04_05 {
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
        driver.close();
    }

    @Test
    public void Test4(){
        SmartBearUtilities.verifyOrder(driver, "Charles Dodgeson");
    }

    @Test
    public void Test5(){
        SmartBearUtilities.printNamesAndCities(driver);
    }

}
