package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class addNewFirstRulePage extends PageBase{
    public addNewFirstRulePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "ddlAgencyCode")
    WebElement entityList;

    @FindBy(id = "ddlAccountTypeId")
    WebElement AccountType;

    @FindBy(id = "ddlprojectItemNumber")
    WebElement AccountNumber;

    @FindBy(xpath = "//*[@id=\"form-request1\"]/div/div[5]/span/div/div/select")
    WebElement transferWay;

    @FindBy(xpath = "//*[@id=\"form-request1\"]/div/div[6]/span/div/div/select")
    WebElement transferType;

    @FindBy(id = "dtPeriodFrom")
    WebElement dataFrom;

    @FindBy(id = "dtPeriodTo")
    WebElement dataTo;

    @FindBy(xpath = "//input[@placeholder='الرجاء ادخال المبلغ المسموح به هنا']")
    WebElement amountValue;

    @FindBy(xpath = "//input[@placeholder='الرجاء ادخال رقم المستند الداعم هنا']")
    WebElement docmentNumber;

    @FindBy(xpath = "//*[@id=\"form-request1\"]/div/div[12]/span/div/div/select")
    WebElement docmentType;

    @FindBy(css = "button.btn.arrow-btn.btn-primary-light.btn-lg.mx-0.mx-md-2.mt-2.mt-md-0")
    WebElement addNewRuleBtn;

    public void selectEntity(String value){
        Select list = new Select(entityList);
        list.selectByValue(value);
    }

    public void SelectAccountType(String value){
        Select list = new Select(AccountType);
        list.selectByValue(value);
    }

    public void SelectAccountNumber(String projectNumber){
        Select list = new Select(AccountNumber);
        list.selectByValue(projectNumber);
    }

    public void SelectTransferWay(String value){
        Select list = new Select(transferWay);
        list.selectByValue(value);
    }

    public void SelectTransferType(String value){
        Select list = new Select(transferType);
        list.selectByValue(value);
    }

    public void selectDates() throws InterruptedException {
        clickButton(dataFrom);
        Thread.sleep(1000);
        //clickButton(dataTo);
        setTextWebElement(dataTo,"2022-06-11");
        clickButton(amountValue);
    }

    public void enterAmountValue(String amountValue2){
        setTextWebElement(amountValue,amountValue2);
    }

    public void enterDocmentData(String docNumber , String Value){
        setTextWebElement(docmentNumber ,docNumber);
        Select list = new Select(docmentType);
        list.selectByValue(Value);

    }

    public void clickOnAddNewRule(){
        clickButton(addNewRuleBtn);
    }


}
