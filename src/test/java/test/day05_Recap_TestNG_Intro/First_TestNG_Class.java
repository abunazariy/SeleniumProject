package test.day05_Recap_TestNG_Intro;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class First_TestNG_Class {

    @BeforeMethod
    public void setUp(){
        System.out.println("Before method is running...");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("After method is running...");
    }

    @Test
    public void test1(){
        System.out.println("Test 1 is running...");
    }
    @Test
    public void test2(){
        System.out.println("Test 2 is running...");
    }
}
