package test.day03_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_3_CybertekURL_Verification {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        Thread.sleep(1000);
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("username@domain.ext");
        Thread.sleep(1000);
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();
        Thread.sleep(1000);
        String expectedURLcontains = "email_sent";
        if (driver.getCurrentUrl().contains(expectedURLcontains)){
            System.out.println(driver.getCurrentUrl()+" email_sent URL contains PASSED");
        }else {
            System.out.println(driver.getCurrentUrl()+" email_sent URL contains FAILED");
        }
        WebElement confirmationMessage = driver.findElement(By.name("confirmation_message"));
        String actualMessageValue = confirmationMessage.getText();
        String expectedMessageValue = "Your e-mail's been sent!";
        if (actualMessageValue.equals(expectedMessageValue)){
            System.out.println(actualMessageValue+" Confirmation message verification PASSED!");
        }else {
            System.out.println(actualMessageValue+" Confirmation message verification FAILED!");
        }
        if (confirmationMessage.isDisplayed()){
            System.out.println("Confirmation message is DISPLAYED");
        }else{
            System.out.println("Confirmation message is NOT displayed");
        }

        driver.close();



    }
}
