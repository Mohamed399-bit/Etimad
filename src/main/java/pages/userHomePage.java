package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class userHomePage extends PageBase{
    public userHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='row pb-5']")
    WebElement divComp;

    @FindBy(xpath = "/html/body/header/div[1]/div/div/div[1]/div/ul/li[2]/a")
    public WebElement inboxBtn;

    List<WebElement> list = divComp.findElements(By.xpath("//div[@class='col-12 col-md-3']"));

    public void clickOnInternalTransfer(){
        clickButton(list.get(0));
    }

    public void clickOnInboxButton(){
        clickButton(inboxBtn);
    }
}
