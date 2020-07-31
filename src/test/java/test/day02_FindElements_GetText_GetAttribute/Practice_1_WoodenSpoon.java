package test.day02_FindElements_GetText_GetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_1_WoodenSpoon {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.get("https://www.etsy.com");
        Thread.sleep(1000);
        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("Wooden spoon"+ Keys.ENTER);
        Thread.sleep(1000);
        if (driver.getTitle().equals("Wooden spoon | Etsy")){
            System.out.println("Etsy Title Verification PASSED!");
        }else{
            System.out.println("Etsy Title Verification FAILED!");
        }
        Thread.sleep(1000);
        driver.close();
    }
}
