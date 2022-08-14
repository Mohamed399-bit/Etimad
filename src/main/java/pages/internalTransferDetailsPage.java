package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class internalTransferDetailsPage extends PageBase{
    public internalTransferDetailsPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
    }

    @FindBy(css = "button.btn.btn-primary-light.btn-md.mx-2.mt-2.mt-md-0")
    WebElement approvedBtn;

    @FindBy(css = "button.btn.btn-secondary-blue.btn-md.mx-2.mt-2.mt-md-0")
    WebElement returnBtn;

    @FindBy(css = "button.btn.btn-danger.btn-md.mx-2.mt-2.mt-md-0")
    WebElement rejectBtn;

    @FindBy(xpath = "//textarea[@placeholder='الرجاء إدخال ملاحظات الاعتماد']")
    WebElement noteTextArea;

    @FindBy(xpath = "//*[@id=\"actionTransfer\"]/div/div/div[3]/button[2]")
    WebElement approvedBtnFromPopup;

    @FindBy(xpath = "//*[@id=\"successTransfer\"]/div/div/div/div/div[2]/button")
    WebElement backToInboxBtn;

    public void clickOnApprovedButton(){
        scrollToBottom();
        clickButton(approvedBtn);
    }

    public void clickOnReturnButton(){
        scrollToBottom();
        clickButton(returnBtn);
    }

    public void clickOnRejectButton(){
        scrollToBottom();
        clickButton(rejectBtn);
    }
    public void enterNotes(String note){
        setTextWebElement(noteTextArea,note);
    }

    public void clickOnApprovedBtnFromPopup(){
        clickButton(approvedBtnFromPopup);
    }

    public void clickOnBackInboxButton(){
        clickButton(backToInboxBtn);
    }
}
