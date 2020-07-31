package test.day12_Synchronization;

import Utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Loading1Page;
import pages.Loading7Page;

public class ExplicitWaitPractices {
    /*
    1. Go to http://practice.cybertekschool.com/dynamic_loading/7
    2. Wait until title is “Dynamic Title”
    3. Assert : Message “Done” is displayed.
    4. Assert : Image is displayed.
     */

    @Test
    public void dynamic_title(){
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/7");
        WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(), 8);
        Loading7Page loading7Page = new Loading7Page();
        String expectedTitle = "Dynamic title";

        webDriverWait.until(ExpectedConditions.titleIs(expectedTitle));

        Assert.assertTrue(loading7Page.doneMessage.isDisplayed());

        Assert.assertTrue(loading7Page.spongeBobImage.isDisplayed());



    }
    /*
    1. Go to http://practice.cybertekschool.com/dynamic_loading/1
    2. Click to start
    3. Wait until loading bar disappears
    4. Assert username inputbox is displayed
    5. Enter username: tomsmith
    6. Enter password: incorrectpassword
    7. Click to Submit button
    8. Assert “Your username is invalid!” text is displayed.
     */

    @Test
    public void dynamic_page(){
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");
        Loading1Page loading1Page = new Loading1Page();
        loading1Page.startButton.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(loading1Page.usernameInput));
        Assert.assertTrue(loading1Page.usernameInput.isDisplayed());
        loading1Page.usernameInput.sendKeys("hebhrbjr");
        loading1Page.passwordInput.sendKeys("hxvshbejbe");
        loading1Page.submitButton.click();

        Assert.assertTrue(loading1Page.invalidUsernameMessage.isDisplayed());




    }
}
