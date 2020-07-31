package test.day10_JSExecutor_Upload_Actions;

import Utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClickTest {
    @Test
    public void double_click_test()throws Exception{
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        WebElement iframe = Driver.getDriver().findElement(By.xpath("//iframe[@id='iframeResult']"));
        Driver.getDriver().switchTo().frame(iframe);
        WebElement clickMeText = Driver.getDriver().findElement(By.xpath("//body/p[@id='demo']"));
        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(3000);
        actions.moveToElement(clickMeText).doubleClick().perform();
        String afterClickTextStyleAttribute = Driver.getDriver().findElement(By.xpath("//body/p[@style='color: red;']")).getAttribute("style");
        Assert.assertTrue(afterClickTextStyleAttribute.contains("red"));
        Driver.getDriver().switchTo().defaultContent();


    }

    @Test
    public void hover_test()throws Exception{
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Driver.getDriver().manage().window().maximize();
        Thread.sleep(3000);
        WebElement cookiesAcceptButton = Driver.getDriver().findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookiesAcceptButton.click();
        WebElement smallCircle = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement bigCircle = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(3000);
        actions.dragAndDrop(smallCircle, bigCircle).perform();
        Assert.assertTrue(bigCircle.getText().equals("You did great!"));
    }

    @Test
    public void context_click()throws Exception{
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");
        Driver.getDriver().manage().window().maximize();
        Thread.sleep(3000);
        WebElement box = Driver.getDriver().findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(box).perform();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

    }
}
