package test.day04_FindElements_Checkbox_Radio;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class P_04_CybertekCheckbox {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox']"));
        if (!checkBox1.isSelected()){
            System.out.println("Checkbox 1 is not selected by default, PASSED!!!");
        }else{
            System.out.println("Checkbox 1 is selected by default, FAILED!!!");
        }
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        if (checkBox2.isSelected()){
            System.out.println("Checkbox 2 is selected by default, PASSED!!!");
        }else{
            System.out.println("Checkbox 2 is not selected by default, FAILED!!!");
        }
        checkBox1.click();
        checkBox2.click();
        if (checkBox1.isSelected()){
            System.out.println("Checkbox 1 is selected, PASSED!!!");
        }else{
            System.out.println("Checkbox 1 is not selected, FAILED!!!");
        }
        if (!checkBox2.isSelected()){
            System.out.println("Checkbox 2 is not selected, PASSED!!!");
        }else{
            System.out.println("Checkbox 2 is selected, FAILED!!!");
        }
        driver.close();

    }

}
