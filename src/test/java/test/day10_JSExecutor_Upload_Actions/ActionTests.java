package test.day10_JSExecutor_Upload_Actions;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionTests {

    @Test
    public void hover_over_test1()throws Exception{
        Driver.getDriver().get("https://www.amazon.com");
        Actions actions = new Actions(Driver.getDriver());
        WebElement languageSelectButton = Driver.getDriver().findElement(By.id("icp-nav-flyout"));
        Thread.sleep(5000);
        actions.moveToElement(languageSelectButton).perform();

    }

    @Test
    public void hover_over_practice1() throws Exception{
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");
        WebElement picture1 = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[1]"));
        WebElement picture2 = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[2]"));
        WebElement picture3 = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[3]"));
        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(2000);

        actions.moveToElement(picture1).perform();
        WebElement user1nameText = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        Assert.assertTrue(user1nameText.isDisplayed());
        Thread.sleep(2000);

        actions.moveToElement(picture2).perform();
        WebElement user2nameText = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        Assert.assertTrue(user2nameText.isDisplayed());
        Thread.sleep(2000);

        actions.moveToElement(picture3).perform();
        WebElement user3nameText = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));
        Assert.assertTrue(user3nameText.isDisplayed());
        Thread.sleep(2000);

    }
}
