package test.day03_cssSelector_xpath;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cssSelectorExample {
    public static void main(String[] args) throws Exception {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");
        WebElement amazonSearch = driver.findElement(By.cssSelector("input[autocomplete='off']"));
        amazonSearch.sendKeys("wooden spoon" + Keys.ENTER);
        Thread.sleep(1000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "wooden spoon";
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title verification PASSED");
        }else{
            System.out.println("Title verification FAILED");
        }
        driver.close();
    }
}
