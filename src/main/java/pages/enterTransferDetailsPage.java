package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class enterTransferDetailsPage extends PageBase{
    public enterTransferDetailsPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor)driver;
         wait = new WebDriverWait(driver,30);
    }

    @FindBy(xpath = "//span[text()='منقول منه']")
    WebElement transferFromBtn;

    @FindBy(xpath = "//span[text()='منقول اليه']")
    WebElement transferToBtn;

    @FindBy(xpath = "//div[@class='dropdown bootstrap-select form-control new show']")
    WebElement entityList;

    @FindBy(id = "govAgency")
    WebElement govAgencyList;

    @FindBy(id = "accountType")
    WebElement accountTypeList;

    @FindBy(id = "accountNum")
    WebElement accountNumList;

    @FindBy(xpath = "//button[@class='btn btn-primary-light btn-sm']")
    WebElement SearchForAccountBtn;

    @FindBy(xpath = "//*[@id=\"App\"]/div/div[4]/div[1]/div/div[3]/div/div/div/div[2]/div[9]/div/input")
    WebElement transferValueTxt;

    @FindBy(xpath = "//button[@class='btn btn-primary-light btn-md px-4']")
    WebElement addBtn;

    @FindBy(css = "button.btn.arrow-btn.btn-primary-light.btn-lg.mx-2.mt-2.mt-md-0")
    WebElement saveAndNext;

    @FindBy(css = "p.text-secondary-blue")
    public WebElement headerTxt;

    public void clickOnTransferFrom(){
        wait.until(ExpectedConditions.elementToBeClickable(transferFromBtn));
        clickButton(transferFromBtn);
    }

    public void clickOnTransferTO(){
        clickButton(transferToBtn);
    }


    public void selectEntity(int index){
        //clickButton(entityList);

       // wait.until(ExpectedConditions.elementToBeClickable(govAgencyList));
        Select list = new Select(govAgencyList);
        list.selectByIndex(index);
    }

    public void SelectAccountType(int index){

       // wait.until(ExpectedConditions.elementToBeClickable(accountTypeList));
        Select select = new Select(accountTypeList);
        select.selectByIndex(index);
    }

    public void SelectAccountNumber(int index){

        //wait.until(ExpectedConditions.visibilityOf(accountNumList));
        Select select2 = new Select(accountNumList);
        select2.selectByIndex(index);
    }

    public void SearchAboutAccount(){
        wait.until(ExpectedConditions.elementToBeClickable(SearchForAccountBtn));
        clickButton(SearchForAccountBtn);
    }

    public void enterTransferValue(String value) throws InterruptedException {
        setTextWebElement(transferValueTxt,value);
        wait.until(ExpectedConditions.elementToBeClickable(addBtn));
        clickButton(addBtn);
    }

    public void clickOnSaveAndNext(){
        scrollToBottom();
        clickOnButtonUsingJavaScript(saveAndNext);
        //clickButton(saveAndNext);
    }


}
