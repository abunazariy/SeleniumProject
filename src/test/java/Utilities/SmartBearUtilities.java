package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtilities {
    public static void login(WebDriver driver){

        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']")).sendKeys("Tester");
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    public static void verifyOrder(WebDriver driver, String name){

        List <WebElement> listOfNames = driver.findElements(By.xpath("//table[@class='SampleTable']//td[2]"));
        for (WebElement each : listOfNames) {
            if (each.getText().equals(name)){
                Assert.assertTrue(true);
                return;
            }
        }
        Assert.fail();
    }

    public static void printNamesAndCities(WebDriver driver){
        List <WebElement> listOfNames = driver.findElements(By.xpath("//table[@class='SampleTable']//td[2]"));
        List <WebElement> listOfCities = driver.findElements(By.xpath("//table[@class='SampleTable']//td[7]"));
        int count =0;
        for (int i=0; i<listOfNames.size(); i++){
            count++;
            System.out.println("Name"+count+": "+listOfNames.get(i).getText()+", "+"City"+count+": "+listOfCities.get(i).getText());
        }
    }

    public static void removeName(WebDriver driver, String name){

            WebElement paulBrown = driver.findElement(By.xpath("(//tbody)[2]//td[.='"+name+"']/../td[1]"));
            paulBrown.click();
            WebElement deleteButton = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$btnDelete']"));
            deleteButton.click();
            List<WebElement> listOfNames = driver.findElements(By.xpath("//table[@class='SampleTable']//td[2]"));
            for (WebElement eachName: listOfNames){
                Assert.assertFalse(eachName.getText().equals(name));
        }
    }
}
