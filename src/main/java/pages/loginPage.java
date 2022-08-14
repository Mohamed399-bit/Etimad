package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends PageBase{
    public loginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Username")
    WebElement idTxt;

    @FindBy(id = "Password")
    WebElement passwordTxt;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    public void login(String id , String password) throws InterruptedException {
        setTextWebElement(idTxt,id);
        Thread.sleep(1000);
        setTextWebElement(passwordTxt,password);
        Thread.sleep(1000);
        clickButton(loginBtn);
    }
}
