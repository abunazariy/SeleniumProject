package test.day07_JavaFaker_WebTables;

import Utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Practice_06 {

    WebDriver driver;

    @BeforeClass
    public void seUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/registration_form");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown()throws Exception{
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void Test6(){
        Faker faker = new Faker();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(faker.name().username().replace(".", ""));
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(faker.bothify("dhfbfn@hhffh.vjf"));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(faker.numerify("145236987"));
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(faker.bothify("142-254-2585"));
        driver.findElement(By.xpath("//input[@value='male']")).click();
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys(faker.bothify("12/20/1985"));
        Select department = new Select(driver.findElement(By.name("department")));
        department.selectByVisibleText("Department of Engineering");
        Select jobType = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        jobType.selectByVisibleText("SDET");
        driver.findElement(By.xpath("//input[@value='java']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String actualMessage = driver.findElement(By.xpath("//body//p")).getText();
        String expectedMessage = "You've successfully completed registration!";
        Assert.assertTrue(actualMessage.equals(expectedMessage));

    }
}
