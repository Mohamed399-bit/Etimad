package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class transferData1Page extends PageBase{
    public transferData1Page(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='اعتماد']")
    WebElement typeOfTransfer;

    @FindBy(xpath = "//span[text()='أمر سامي']")
    WebElement decisionType;

    @FindBy(xpath = "//input[@class='form-control']")
    WebElement decisionNumberTxt;

    @FindBy(id = "dtdecisionDate")
    WebElement dtdecisionDatetxt;

    @FindBy(id = "description")
    WebElement descriptionTxt;

    @FindBy(xpath = "//*[@id=\"fine-uploader-manual-trigger-small-8\"]/div/div/div/div[3]/div/span[2]/div/input")
    WebElement fileUpload;

    @FindBy(xpath = "//button[@class='btn arrow-btn btn-primary-light btn-lg mx-2 mt-2 mt-md-0']")
    WebElement saveAndNextBtn;


    public void clickOnEtimad(){
        clickButton(typeOfTransfer);
    }

    public void clickOnDecisionType(){
        clickButton(decisionType);
    }

    public void enterDecisionNumber(String decisionNumber){
        setTextWebElement(decisionNumberTxt,decisionNumber);
    }

    public void selectDate(){
        clickButton(dtdecisionDatetxt);
        clickButton(descriptionTxt);
    }

    public void enterDescription(String description){
        setTextWebElement(descriptionTxt,description);
    }

    public void uploadFile(String path){
        fileUpload.sendKeys(path);
    }

    public void clickOnSaveAndNext(){
        clickButton(saveAndNextBtn);
    }


}
