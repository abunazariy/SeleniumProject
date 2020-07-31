package pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hovers {
    public Hovers(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//div[@class='figure'][1]")
    public WebElement image1;

    @FindBy(xpath = "//div[@class='figure'][2]")
    public WebElement image2;

    @FindBy(xpath = "//div[@class='figure'][3]")
    public WebElement image3;

    @FindBy(xpath = "(//h5)[1]")
    public WebElement image1Info;

    @FindBy(xpath = "(//h5)[2]")
    public WebElement image2Info;

    @FindBy(xpath = "(//h5)[3]")
    public WebElement image3Info;








}
