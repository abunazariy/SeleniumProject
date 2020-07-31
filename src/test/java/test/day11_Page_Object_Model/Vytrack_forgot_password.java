package test.day11_Page_Object_Model;

import Utilities.Configuration_Reader;
import Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Vytrack_forgot_password {
    @Test
    public void vytrack_forgot_password_verification(){
        Driver.getDriver().get(Configuration_Reader.getProperty("vytrack_url"));
        LoginPage loginPage = new LoginPage();
        loginPage.forgotPasswordLink.click();

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Forgot Password";

        Assert.assertEquals(actualTitle, expectedTitle);

        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURL = "https://qa2.vytrack.com/user/reset-request";

        Assert.assertEquals(actualURL, expectedURL);

    }

    @Test
    public void vytrack_error_message_verification(){
        Driver.getDriver().get("https://qa2.vytrack.com/user/reset-request");

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("hsbhefef");
        loginPage.requestButton.click();

        String expectedInLineErrorMessage = "There is no active user with username or email address";

        Assert.assertTrue(loginPage.noActiveUserErrorMessage.isDisplayed());

        Assert.assertTrue(loginPage.noActiveUserErrorMessage.getText().contains(expectedInLineErrorMessage));

    }
}
