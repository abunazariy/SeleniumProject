package test.day01_Selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_2 {
    public static void main(String[] args)throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.get("https://www.cybertekschool.com");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Cybertek";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title Verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }

        if (driver.getCurrentUrl().contains("cybertekschool")){
            System.out.println("URL contains verification PASSED!");
        }else{
            System.out.println("URL contains verification FAILED!");
        }
        driver.close();


    }
}
