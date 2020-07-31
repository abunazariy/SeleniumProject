package test.day04_FindElements_Checkbox_Radio;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P_05_SeleniumEasyCheckbox_2 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement checkAllButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        String checkAllButtonText = checkAllButton.getAttribute("value");
        String expectedText = "Check All";
        if (checkAllButtonText.equals(expectedText)){
            System.out.println(" Check all button text verification PASSED!!!");
        }else{
            System.out.println(" Check all button text verification FAILED!!!");
        }
        checkAllButton.click();

        List <WebElement> checkboxList = driver.findElements(By.xpath("//input[@class='cb1-element']"));
        for (WebElement eachCheckbox: checkboxList){
            if (eachCheckbox.isSelected()){
                System.out.println("Check box is selected verification PASSED!!!");
            }else{
                System.out.println("Check box is NOT selected verification FAILED!!!");
            }
        }
        WebElement checkAllButton2 = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        String checkAllButtonText2 = checkAllButton2.getAttribute("value");
        if (checkAllButtonText2.equals("Uncheck All")){
            System.out.println("Check all button text verification PASSED!!!");
        }else{
            System.out.println("Check all button text verification FAILED!!!");
        }
        driver.close();
    }
}
