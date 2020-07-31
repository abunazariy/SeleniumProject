package test.day03_cssSelector_xpath;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P_1_xpath {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
        if (homeLink.isDisplayed()){
            System.out.println("Home link is displayed on page verification PASSED");
        }else{
            System.out.println("Home link is displayed on page verification FAILED");
        }
        WebElement forgotPasswordHeader = driver.findElement(By.xpath("//div[@class='example']/h2"));
        if (forgotPasswordHeader.isDisplayed()){
            System.out.println("Forgot Password header is displayed on page verification PASSED!!!");
        }else{
            System.out.println("Forgot Password header is displayed on page verification FAILED!!!");
        }
        WebElement emailTextLink = driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']/label"));
        if (emailTextLink.isDisplayed()){
            System.out.println("email text link verification PASSED!!!");
        }else{
            System.out.println("email text link verification FAILED!!!");
        }
        WebElement emailInputBox = driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']//input"));
        if (emailInputBox.isDisplayed()){
            System.out.println("email iput box is displayed");
        }else{
            System.out.println("email input box is NOT displayed");
        }
        WebElement retrievePassworButton = driver.findElement(By.xpath("//button//i"));
        if (retrievePassworButton.isDisplayed()){
            System.out.println("retrieve password button is diplayed");
        }else{
            System.out.println("retrieve password button is NOT diplayed");
        }
        WebElement poweredByCybertekSchoolText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        if (poweredByCybertekSchoolText.isDisplayed()){
            System.out.println("Powered by cybertek school text is displayed");
        }else{
            System.out.println("Powered by cybertek school text is NOT displayed");
        }
        driver.close();
    }
}
