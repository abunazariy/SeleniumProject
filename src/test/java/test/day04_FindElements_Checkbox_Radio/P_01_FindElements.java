package test.day04_FindElements_Checkbox_Radio;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P_01_FindElements {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.merriam-webster.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        List <WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        int linksWithNoText = 0;
        int linksWithText = 0;

        for (WebElement eachLink: listOfLinks){
            System.out.println(eachLink.getText());
            if (eachLink.getText().isEmpty()){
                linksWithNoText++;
            }else {
                linksWithText++;
            }
        }
        System.out.println("Links without text "+linksWithNoText);
        System.out.println("Links with text "+linksWithText );
        System.out.println(listOfLinks.size());
        driver.close();



    }
}
