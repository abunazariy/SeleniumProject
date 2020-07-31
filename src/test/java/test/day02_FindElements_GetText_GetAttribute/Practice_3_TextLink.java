package test.day02_FindElements_GetText_GetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_3_TextLink {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.get("https://www.google.com");
        Thread.sleep(1000);
        driver.findElement(By.linkText("Gmail")).click();
        Thread.sleep(1000);
        if (driver.getTitle().contains("Gmail")){
            System.out.println("Gmail Title Verification PASSED!");
        }else{
            System.out.println("Gmail Title Verification FAILED!");
        }
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        if (driver.getTitle().equals("Google")){
            System.out.println("Google Title Verification PASSED!");
        }else{
            System.out.println("Google Title Verification FAILED!");
        }
        driver.close();
    }
}
