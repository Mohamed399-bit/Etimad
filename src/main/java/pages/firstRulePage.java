package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class firstRulePage extends PageBase{
    public firstRulePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.btn.btn-primary-light.btn-lg")
    WebElement addNewRuleBtn;

    public void clickOnAddNewRule(){
        clickButton(addNewRuleBtn);
    }
}
