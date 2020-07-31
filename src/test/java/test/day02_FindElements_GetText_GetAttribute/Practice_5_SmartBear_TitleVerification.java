package test.day02_FindElements_GetText_GetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_5_SmartBear_TitleVerification {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        Thread.sleep(1000);

        String actualTitleLogin = driver.getTitle();
        String expectedTitleLogin = "Web Orders Login";

        if (actualTitleLogin.equals(expectedTitleLogin)){
            System.out.println("Web Orders Login Title Verification PASSED!");
        }else{
            System.out.println("Web Orders Login Title Verification FAILED!");
        }
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();

        String actualTitleWebOrders = driver.getTitle();
        String expectedTitleWebOrders = "Web Orders";

        if (actualTitleWebOrders.equals(expectedTitleWebOrders)){
            System.out.println("Web Orders Title Verification PASSED!");
        }else{
            System.out.println("Web Orders Title Verification FAILED!");
        }
        Thread.sleep(1000);
        driver.close();
    }
}
