package test.day11_Page_Object_Model;

import Utilities.Configuration_Reader;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.LoginPage;

public class NegativeLoginTest {
    @Ignore
    @Test
    public void negative_login_test(){
        Driver.getDriver().get(Configuration_Reader.getProperty("vytrack_url"));
        WebElement userNameInput = Driver.getDriver().findElement(By.id("prependedInput"));
        WebElement passwordInput = Driver.getDriver().findElement(By.id("prependedInput2"));
        WebElement submitButton = Driver.getDriver().findElement(By.id("_submit"));
        userNameInput.sendKeys(Configuration_Reader.getProperty("storemanager_username"));
        passwordInput.sendKeys("bjrkrfkrnf");
        submitButton.click();
        String actualErrorMessage = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']/div")).getText();
        String expectedMessage = "Invalid user name or password.";
        Assert.assertTrue(actualErrorMessage.equals(expectedMessage));


    }

    @Test
    public void page_object(){
        Driver.getDriver().get(Configuration_Reader.getProperty("vytrack_url"));
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(Configuration_Reader.getProperty("storemanager_username"));
        loginPage.passwordInput.sendKeys("hjbfjegje");
        loginPage.loginButton.click();
        String expectedErrorMessage = "Invalid user name or password.";
        Assert.assertTrue(loginPage.errorMessage.getText().equals(expectedErrorMessage));

        loginPage.usernameInput.clear();
        loginPage.usernameInput.sendKeys("jhbdjhjeh");
        loginPage.passwordInput.clear();
        loginPage.passwordInput.sendKeys(Configuration_Reader.getProperty("storemanager_password"));
        loginPage.loginButton.click();
        Assert.assertTrue(loginPage.errorMessage.getText().equals(expectedErrorMessage));

        /*
        loginPage.usernameInput.clear();
        loginPage.usernameInput.sendKeys(Configuration_Reader.getProperty("storemanager_username"));
        loginPage.passwordInput.clear();
        loginPage.passwordInput.sendKeys(Configuration_Reader.getProperty("storemanager_password"));
        loginPage.loginButton.click();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
         */

        loginPage.logIn(Configuration_Reader.getProperty("storemanager_username"), Configuration_Reader.getProperty("storemanager_password"));
        String expectedTitle = "Dashboard";
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);





    }
}
