package test.day11_Page_Object_Model;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsPractices {

    @Test
    public void scroll_down()throws Exception{
        Driver.getDriver().get("http://practice.cybertekschool.com");
        Actions actions = new Actions(Driver.getDriver());
        WebElement cybertehSchoolText = Driver.getDriver().findElement(By.linkText("Cybertek School"));
        Thread.sleep(3000);
        actions.moveToElement(cybertehSchoolText).perform();

    }
}
