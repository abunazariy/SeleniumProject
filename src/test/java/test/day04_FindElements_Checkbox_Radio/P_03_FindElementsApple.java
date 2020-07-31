package test.day04_FindElements_Checkbox_Radio;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P_03_FindElementsApple {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.apple.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement mac = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-mac']"));
        mac.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
        List<WebElement> macList = driver.findElements(By.xpath("//body//a"));
        int macLinkWithNoText = 0;
        int macLinkWithText = 0;
        for (WebElement eachMac: macList){
            //System.out.println(eachMac.getText());
            if (eachMac.getText().isEmpty()){
                macLinkWithNoText++;
            }else {
                macLinkWithText++;
            }
        }
        System.out.println("Mac links with NO text "+macLinkWithNoText);
        System.out.println("Mac link WITH text "+macLinkWithText);
        System.out.println("Total Mac LINKS "+macList.size());
        System.out.println("==============================================================================");

        WebElement ipad = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-ipad']"));
        ipad.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
        List<WebElement> ipadList = driver.findElements(By.xpath("//body//a"));
        int ipadLinkWithNoText = 0;
        int ipadLinkWithText = 0;
        for (WebElement eachIpad: ipadList){
            //System.out.println(eachIpad.getText());
            if (eachIpad.getText().isEmpty()){
                ipadLinkWithNoText++;
            }else{
                ipadLinkWithText++;
            }
        }
        System.out.println("Ipad links with NO text "+ipadLinkWithNoText);
        System.out.println("Ipad links WITH text "+ipadLinkWithText);
        System.out.println("Total Ipad LINKS "+ipadList.size());
        System.out.println("==============================================================================");

        WebElement iphone = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']"));
        iphone.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
        List<WebElement> iphoneList = driver.findElements(By.xpath("//body//a"));
        int iphoneLinksWithNoText = 0;
        int iphoneLinksWithText = 0;
        for (WebElement eachIphone: iphoneList){
            //System.out.println(eachIphone.getText());
            if (eachIphone.getText().isEmpty()){
                iphoneLinksWithNoText++;
            }else{
                iphoneLinksWithText++;
            }
        }
        System.out.println("Iphone links with NO text "+iphoneLinksWithNoText);
        System.out.println("Iphone links WITH text "+iphoneLinksWithText);
        System.out.println("Total Iphone LINKS "+iphoneList.size());
        System.out.println("==============================================================================");

        WebElement watch = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-watch']"));
        watch.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
        List<WebElement> watchList = driver.findElements(By.xpath("//body//a"));
        int watchLinksWithNoText = 0;
        int watchLinksWithText = 0;
        for (WebElement eachWatch: watchList){
           // System.out.println(eachWatch.getText());
            if (eachWatch.getText().isEmpty()){
                watchLinksWithNoText++;
            }else{
                watchLinksWithText++;
            }
        }
        System.out.println("Watch links with NO text "+watchLinksWithNoText);
        System.out.println("Watch links WITH text "+watchLinksWithText);
        System.out.println("Total Watch LINKS "+watchList.size());
        System.out.println("==============================================================================");

        WebElement tv = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-tv']"));
        tv.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
        List<WebElement> tvList = driver.findElements(By.xpath("//body//a"));
        int tvLinksWithNoText = 0;
        int tvLinksWithText = 0;
        for (WebElement eachTv: tvList){
            //System.out.println(eachTv.getText());
            if (eachTv.getText().isEmpty()){
                tvLinksWithNoText++;
            }else{
                tvLinksWithText++;
            }
        }
        System.out.println("TV links with NO text "+tvLinksWithNoText);
        System.out.println("TV links WITH text "+tvLinksWithText);
        System.out.println("Total TV LINKS "+tvList.size());
        System.out.println("==============================================================================");

        WebElement music = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-music']"));
        music.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
        List<WebElement> musicList = driver.findElements(By.xpath("//body//a"));
        int musicLinksWithNoText = 0;
        int musicLinksWithText = 0;
        for (WebElement eachMusic: musicList){
            //System.out.println(eachMusic.getText());
            if (eachMusic.getText().isEmpty()){
                musicLinksWithNoText++;
            }else{
                musicLinksWithText++;
            }
        }
        System.out.println("Music links with NO text "+musicLinksWithNoText);
        System.out.println("Music links WITH text "+musicLinksWithText);
        System.out.println("Total Music LINKS "+musicList.size());
        System.out.println("==============================================================================");

        WebElement support = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-support']"));
        support.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
        List<WebElement> supportList = driver.findElements(By.xpath("//body//a"));
        int supportLinksWithNoText = 0;
        int supportLinksWithText = 0;
        for (WebElement eachSupport: supportList){
            //System.out.println(eachSupport.getText());
            if (eachSupport.getText().isEmpty()){
                supportLinksWithNoText++;
            }else{
                supportLinksWithText++;
            }
        }
        System.out.println("Support links with NO text "+supportLinksWithNoText);
        System.out.println("Support links WITH text "+supportLinksWithText);
        System.out.println("Total Support LINKS "+supportList.size());
        System.out.println("==============================================================================");

        int totalLinksWithNoText = macLinkWithNoText+ipadLinkWithNoText+iphoneLinksWithNoText+watchLinksWithNoText+
                tvLinksWithNoText+musicLinksWithNoText+supportLinksWithNoText;
        int totalLinksWithText = macLinkWithText+ipadLinkWithText+iphoneLinksWithText+watchLinksWithText+
                tvLinksWithText+musicLinksWithText+supportLinksWithText;
        int totalLinks = totalLinksWithNoText+totalLinksWithText;
        System.out.println("Total links missing text "+totalLinksWithNoText);
        System.out.println("Total links which have text "+totalLinksWithText);
        System.out.println("Total links "+totalLinks);

        driver.close();


    }
}
