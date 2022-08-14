package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class adminHomePage extends PageBase
{
    public adminHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "layoutContainer")
    public WebElement divComp;

    List<WebElement> rules = divComp.findElements(By.cssSelector("div.col-12.col-md-3"));

    public void listSize(){
        /*
        WebElement div1 = divComp.findElement(By.id("App"));
        WebElement div2 = div1.findElement(By.cssSelector("div.container"));
        WebElement div3 = div2.findElement(By.cssSelector("div.row.pb-5"));
        List<WebElement> list2 = div3.findElements(By.)*/
        System.out.println("List size : " + rules.size());
    }

    public void openTheFirstRule(){
        clickButton(rules.get(0));
    }
}
