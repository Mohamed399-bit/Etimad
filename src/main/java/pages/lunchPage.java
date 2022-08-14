package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class lunchPage extends PageBase {
    public lunchPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor)driver;
        actions = new Actions(driver);
    }

    @FindBy(id = "details-button")
    WebElement advancedBtn;

    @FindBy(id = "proceed-link")
    WebElement proceedLink;

    @FindBy(id = "proceed-button")
    WebElement proceedButton;

    public void clickOnAdvancedButton(){
        clickButton(advancedBtn);
    }

    public void clickONProceedLink(){
        clickButton(proceedLink);
    }

    public void clickOnProceedButton(){
       clickButton(proceedButton);
    }
}
