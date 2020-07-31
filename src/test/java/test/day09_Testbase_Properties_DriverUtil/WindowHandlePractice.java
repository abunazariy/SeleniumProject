package test.day09_Testbase_Properties_DriverUtil;

import test.Base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowHandlePractice extends TestBase {

    @Test
    public void multipleWindowsHandling(){
        driver.get("https://www.amazon.com");
        String defaultWindow = driver.getWindowHandle();
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        for (String eachWindow: driver.getWindowHandles()){
            driver.switchTo().window(eachWindow);
            if (driver.getTitle().contains("Etsy")){
                Assert.assertTrue(true);
                break;
            }
        }

        Assert.assertTrue(driver.getTitle().contains("Etsy"));
        driver.switchTo().window(defaultWindow);





    }
}
