package test.day11_Page_Object_Model;

import Utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Hovers;

public class ActionsPracticesWithPageObjectModel {

    @Test
    public void actions_with_page_obj_model(){
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");

        Hovers hovers = new Hovers();
        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(hovers.image1).perform();
        String expectedTextImage1 = "name: user1";
        Assert.assertTrue(hovers.image1Info.getText().equals(expectedTextImage1));

        actions.moveToElement(hovers.image2).perform();
        String expectedTextImage2 = "name: user2";
        Assert.assertTrue(hovers.image2Info.getText().equals(expectedTextImage2));

        actions.moveToElement(hovers.image3).perform();
        String expectedTextImage3 = "name: user3";
        Assert.assertTrue(hovers.image3Info.getText().equals(expectedTextImage3));


    }
}
