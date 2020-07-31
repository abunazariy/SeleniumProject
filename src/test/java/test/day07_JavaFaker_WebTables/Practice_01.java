package test.day07_JavaFaker_WebTables;

import Utilities.SmartBearUtilities;
import Utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Practice_01 {
    WebDriver driver;

    @BeforeClass
    public void seUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        SmartBearUtilities.login(driver);
    }

    @AfterClass
    public void tearDown()throws Exception{
        Thread.sleep(5000);
        driver.close();
    }

    @Test
    public void Test1(){
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
        int count = 0;

        for (WebElement eachLink : allLinks){
            count++;
            System.out.println(count+" "+eachLink.getText());
        }
    }

    @Test
    public void Test2(){
        driver.findElement(By.xpath("//a[@href='Process.aspx']")).click();
        Select selectProduct = new Select(driver.findElement(By.xpath("//select[@name='ctl00$MainContent$fmwOrder$ddlProduct']")));
        selectProduct.selectByVisibleText("FamilyAlbum");
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']")).sendKeys("2");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Faker faker = new Faker();
        WebElement nameInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
        nameInput.sendKeys(faker.name().fullName());
        WebElement streetInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
        streetInput.sendKeys(faker.address().streetAddress());
        WebElement cityInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']"));
        cityInput.sendKeys(faker.address().city());
        WebElement stateInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']"));
        stateInput.sendKeys(faker.address().state());
        WebElement zipInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));
        zipInput.sendKeys(faker.address().zipCode().replaceAll("-",""));
        WebElement cardTypeInput = driver.findElement(By.xpath("//input[@value='Visa']"));
        cardTypeInput.click();
        WebElement cardNumberInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']"));
        cardNumberInput.sendKeys(faker.finance().creditCard().replaceAll("-",""));
        WebElement cardExpDateInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']"));
        cardExpDateInput.sendKeys("12/25");
        WebElement processButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//strong"));
        Assert.assertTrue(successMessage.isDisplayed());
    }

    @Test
    public void Test3(){
        driver.findElement(By.xpath("//a[.='View all orders']")).click();
        String actualDate = driver.findElement(By.xpath("//td[.='Susan McLaren']/../td[5]")).getText();
        String expectedDate = "01/05/2010";
        Assert.assertTrue(actualDate.equals(expectedDate));
    }
}
