package test.day03_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P_4_ZeroBankURLVerification {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/login.html");
        Thread.sleep(1000);
        WebElement forgotPassworLink = driver.findElement(By.partialLinkText("Forgot"));
        String forgotPasswordLinkValue = forgotPassworLink.getAttribute("href");
        String expectedURLContains = "/forgot-password.html";
        if (forgotPasswordLinkValue.contains(expectedURLContains)){
            System.out.println("URL verification PASSED");
        }else{
            System.out.println("URL verification FAILED");
        }
        System.out.println("Is forgot your password link displayed? "+forgotPassworLink.isDisplayed());
        driver.close();
    }
}
