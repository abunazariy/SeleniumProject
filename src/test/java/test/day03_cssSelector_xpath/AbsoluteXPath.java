package test.day03_cssSelector_xpath;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AbsoluteXPath {
    public static void main(String[] args)throws  Exception {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/nav/ul/li/a")).click();

    }
}
