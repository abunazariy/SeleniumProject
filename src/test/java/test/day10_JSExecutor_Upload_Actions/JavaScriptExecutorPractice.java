package test.day10_JSExecutor_Upload_Actions;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutorPractice {

    @Test
    public void javaScript_executor(){
        Driver.getDriver().get("http://practice.cybertekschool.com");
        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", cybertekSchoolLink );
    }
}
