package test.day04_FindElements_Checkbox_Radio;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class P_05_SeleniumEasyCheckbox {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement successCheckboxCheckedText = driver.findElement(By.xpath("//div[@id='txtAge']"));
        if (!successCheckboxCheckedText.isDisplayed()){
            System.out.println("Success - check box checked text is NOT displayed, PASSED!!!");
        }else {
            System.out.println("Success - check box checked text is displayed, FAILED!!!");
        }
        WebElement singleCheckboxDemo = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        singleCheckboxDemo.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (successCheckboxCheckedText.isDisplayed()){
            System.out.println("Success - check box checked text is displayed, PASSED!!!");
        }else{
            System.out.println("Success - check box checked text is NOT displayed, FAILED!!!");
        }
        driver.close();
    }
}
