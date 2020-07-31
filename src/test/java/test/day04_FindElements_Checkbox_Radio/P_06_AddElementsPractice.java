package test.day04_FindElements_Checkbox_Radio;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P_06_AddElementsPractice {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement addElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int i=1; i<=50; i++){
            addElementButton.click();
        }
        WebElement deleteButton1 = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        List <WebElement> deleteButton = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        int deleteButtonCounter = 0;
        for (WebElement eachDeleteButton: deleteButton){
            // eachDeleteButton.click();
            if (eachDeleteButton.isDisplayed()){
                deleteButtonCounter++;
            }
        }
        if (deleteButtonCounter==50){
            System.out.println("50 delete button displayed on page, PASSED!!!");
        }else{
            System.out.println("FAILED!!!");
        }
        for (WebElement eachDeleteButton: deleteButton){
            eachDeleteButton.click();
        }
        try {
            if (!deleteButton1.isDisplayed()){
                System.out.println("Delete button is NOT displayed on page, PASSED!!!");
            }else{
                System.out.println("Delete button is displayed on page, FAILED!!!");
            }
        }catch (Exception e){
            System.out.println("Exception has been thrown because NO delete button found on page, PASSED!!!");
        }
        driver.close();




    }
}
