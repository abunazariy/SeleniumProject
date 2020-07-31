package test.Base;

import Utilities.Configuration_Reader;
import Utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver(Configuration_Reader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterClass
    public void tearDown()throws Exception{
        Thread.sleep(3000);
        driver.quit();
    }
}
