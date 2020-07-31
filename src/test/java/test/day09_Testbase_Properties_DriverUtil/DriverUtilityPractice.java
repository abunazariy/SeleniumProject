package test.day09_Testbase_Properties_DriverUtil;

import Utilities.Configuration_Reader;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DriverUtilityPractice {

    @Test
    public void driver_utility_practice(){
        Driver.getDriver().get("https://www.google.com");
        WebElement googleSearch = Driver.getDriver().findElement(By.name("q"));
        googleSearch.sendKeys(Configuration_Reader.getProperty("testdata") + Keys.ENTER);
    }
}
