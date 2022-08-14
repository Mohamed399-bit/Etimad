package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPageAfterLogoutPage extends PageBase{
    public loginPageAfterLogoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.loginBtn")
    WebElement loginBtn;

    public void clickOnLoginButton(){
        clickButton(loginBtn);
    }
}
