package test.day02_FindElements_GetText_GetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeaderTextVerification {
    public static void main(String[] args) throws Exception{
        //1.Open Chrome browser
        // 2.Go to http://zero.webappsecurity.com/login.html
        // 3.Verify header textExpected: “Log in to ZeroBank”
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.get("http://zero.webappsecurity.com/login.html");
        Thread.sleep(1000);

        String actualHeaderText = driver.findElement(By.tagName("h3")).getText();
        String expectedHeaderText = "Log in to ZeroBank";

        Thread.sleep(1000);
        if (actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Zero Bank Header Text Verification PASSED!");
        }else{
            System.out.println("Zero Bank Header Text Verification FAILED!");
        }
        Thread.sleep(1000);
        driver.close();
    }
}
