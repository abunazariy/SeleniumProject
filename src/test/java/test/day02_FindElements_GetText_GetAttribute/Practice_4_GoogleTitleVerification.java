package test.day02_FindElements_GetText_GetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_4_GoogleTitleVerification {
    public static void main(String[] args)throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.get("https://www.google.com");
        Thread.sleep(1000);
        // driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);
        driver.findElement(By.name("q")).sendKeys("apple");
        Thread.sleep(1000);
        driver.findElement(By.name("btnK")).click();
        if (driver.getTitle().startsWith("apple")){
            System.out.println("Google Title Verification PASSED!");
        }else{
            System.out.println("Google Title Verification FAILED!");
        }
        Thread.sleep(1000);
        driver.close();


    }
}
