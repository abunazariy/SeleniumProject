package test.day01_Selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSelenium {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize(); // it makes the page full screen
        // driver.manage().window().fullscreen(); // it makes the page full screen and minimizes back
        Thread.sleep(2000);
        driver.get("https://www.walmart.com");
        Thread.sleep(2000);
        driver.navigate().back(); // will take you back
        Thread.sleep(2000);
        driver.navigate().forward(); // takes you next page
        Thread.sleep(2000);
        driver.navigate().refresh(); // refreshes the page
        Thread.sleep(2000);
        driver.navigate().to ("https://www.facebook.com"); // takes you given URL but does not wait until page is fully loaded
        Thread.sleep(2000);
        driver.get("https://www.cybertekschool.com"); // takes you given and waits until the page is fully loaded (recommended to use)
        System.out.println(driver.getTitle()); // returns the title of URL as a String
        System.out.println(driver.getCurrentUrl()); // returns the current URL as a String
        Thread.sleep(2000);
        driver.close(); // closes the current browser tab
        // driver.quit(); // closes all of the tabs and close the session

    }
}
