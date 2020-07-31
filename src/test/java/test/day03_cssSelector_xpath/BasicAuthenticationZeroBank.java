package test.day03_cssSelector_xpath;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasicAuthenticationZeroBank {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://zero.webappsecurity.com/login.html");
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();
        WebElement username = driver.findElement(By.className("dropdown-toggle"));
        if (username.isDisplayed()){
            System.out.println("Username is displayed on page, PASS!");
        }else{
            System.out.println("Username is NOT displayed on page, FAIL!!!");
        }
        String actualTitle = driver.getTitle();
        String expectedTitle = "Zero - Account Summary";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED");
        }else{
            System.out.println("Title verification FAILED");
        }
        WebElement accountSummaryLink = driver.findElement(By.linkText("Account Summary"));
        String accountSummaryLinkValue = accountSummaryLink.getAttribute("href");
        if (accountSummaryLinkValue.contains("account-summary")){
            System.out.println(accountSummaryLinkValue+" Account summary link value containd verification PASSED!!!");
        }else{
            System.out.println(accountSummaryLinkValue+" Account summary link value containd verification FAILED!!!");
        }
        driver.close();

    }
}
