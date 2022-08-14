package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class applyTransferPage extends PageBase{
    public applyTransferPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor)driver;
    }

    @FindBy(css = "button.btn.arrow-btn.btn-primary-light.btn-lg.mx-2.mt-2.mt-md-0")
    WebElement applyTransferBtn;

    @FindBy(css = "button.btn.btn-primary-light.btn-md")
    WebElement confirmBtn;

    @FindBy(css = "div.alert-action")
    WebElement divAlert;

    @FindBy(xpath = "//*[@id=\"successSendTransfer\"]/div/div/div/div/div[1]/div/p")
    WebElement transferId;


    public void clickOnApplyTransfer(){
        scrollToBottom();
        clickOnButtonUsingJavaScript(applyTransferBtn);
    }

    public void clickOnApplyTransferFromConfirmationPopup(){
        clickOnButtonUsingJavaScript(confirmBtn);
    }

    public void returnToRequestList(){
        WebElement returnTORequestListBtn = divAlert.findElement(By.cssSelector("button.btn.btn-primary-light"));
        clickButton(returnTORequestListBtn);
    }

    public void getTransferId(){
        String text = transferId.getText();
        System.out.println(text);
        String id = text.replaceAll("[^\\d]", "");
        System.out.println("Transfer Id : " + id);
    }

    public String getTransferId2(){
        String text = transferId.getText();
        return text.replaceAll("[^\\d]", "");
    }
}
