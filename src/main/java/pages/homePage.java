package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class homePage extends PageBase{
    public homePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class = 'row border-bottom pb-5 justify-content-center']")
    WebElement div1;

    List<WebElement> div2 = div1.findElements(By.xpath("//div[@class = 'col-12 col-md-4 col-lg-3']"));

    public void clickOnEntityGov(){
        clickButton(div2.get(0));
    }
}
