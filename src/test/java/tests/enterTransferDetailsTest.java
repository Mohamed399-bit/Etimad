package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.SetURL;

public class enterTransferDetailsTest extends TestBase {

    lunchPage lunchObject;
    userHomePage userHomeObject;
    InternalTransferPage internalTransferObject;
    transferData1Page transferData1Object;
    enterTransferDetailsPage enterTransferDetailsObject;

    @Test(priority = 2)
    public void enterTransferDetails() throws InterruptedException {

        /*SetURL.lunch();
        lunchObject = new lunchPage(driver);
        lunchObject.clickOnProceedButton();
*/
        userHomeObject = new userHomePage(driver);
        userHomeObject.clickOnInternalTransfer();

        internalTransferObject = new InternalTransferPage(driver);
        internalTransferObject.clickOnAddNewTransfer();

        transferData1Object = new transferData1Page(driver);
        transferData1Object.clickOnEtimad();
        transferData1Object.clickOnDecisionType();
        transferData1Object.enterDecisionNumber("120");
        transferData1Object.selectDate();
        transferData1Object.enterDescription("dsfsfdsfdsffsddsf");
        transferData1Object.uploadFile(System.getProperty("user.dir") + "\\uploadFile\\مرفقات.docx");
        System.out.println("File is Uploaded Successfully");
        Thread.sleep(3000);
        transferData1Object.clickOnSaveAndNext();

        enterTransferDetailsObject = new enterTransferDetailsPage(driver);
        Assert.assertTrue(enterTransferDetailsObject.headerTxt.isDisplayed());
        System.out.println(enterTransferDetailsObject.headerTxt.getText());
        Thread.sleep(3000);
    }
}
