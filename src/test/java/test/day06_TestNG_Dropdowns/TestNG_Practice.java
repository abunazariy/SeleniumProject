package test.day06_TestNG_Dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Practice {
    @BeforeClass
    public void before_class(){
        System.out.println("Before class is running...");
    }
    @AfterClass
    public void after_class(){
        System.out.println("After class is running...");
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("Before method is running...");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("After method is runnung...");
    }
    @Test
    public void test1(){
        System.out.println("Test 1 is running...");
        Assert.assertEquals("string1", "string1", "Verification failed");
    }
    @Ignore
    @Test
    public void test2(){
        System.out.println("Test 2 is running...");
    }
    @Test
    public void test3(){
        System.out.println("Test 3 is running...");
        String actualTitle = "Amazon prime";
        String expectedInTitle = "prime";
        Assert.assertTrue(actualTitle.contains(expectedInTitle), "Verification failed!!!");
        Assert.assertFalse(actualTitle.contains("Prime"), "Verification failed!!!");
    }
}
