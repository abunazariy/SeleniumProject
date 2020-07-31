package test.day10_JSExecutor_Upload_Actions;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Uploading {

    @Test
    public void uploading_practice(){
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");
        WebElement chooseFileButton = Driver.getDriver().findElement(By.id("file-upload"));
        chooseFileButton.sendKeys("C:\\Users\\abdul\\Desktop\\test");
        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();
        WebElement fileUploadedText = Driver.getDriver().findElement(By.xpath("//div[@class='example']/h3"));
        Assert.assertTrue(fileUploadedText.isDisplayed());
    }
}
