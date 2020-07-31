package test.day03_cssSelector_xpath;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P_2_xpath_AddRemoveElements {
    public static void main(String[] args)throws Exception {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div//button")).click();
        WebElement deleteButton = driver.findElement(By.xpath("//div//button[@class='added-manually']"));
        if (deleteButton.isDisplayed()){
            System.out.println("Delete button is displayed on page");
        }else{
            System.out.println("Delete button is NOT displayed on page");
        }
        deleteButton.click();
        try {
            deleteButton.click();
            if (!deleteButton.isDisplayed()){
                System.out.println("PASSED!!!");
            }else{
                System.out.println("FAILED");
            }
        }catch (Exception e){
            System.out.println("Exception has been thrown");
            System.out.println("It means delete button has not been found ");
        }
        driver.close();

    }


}
