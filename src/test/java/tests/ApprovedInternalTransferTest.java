package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ApprovedInternalTransferTest extends TestBase {

    lunchPage lunchObject;
    userHomePage userHomeObject;
    inBoxPage inBoxObject;
    internalTransferDetailsPage internalTransferDetailsObject;
    InternalTransferPage internalTransferObject;

    @Test(priority = 5)
    public void enterTransferDetails() throws InterruptedException {

        /*SetURL.lunch();
        lunchObject = new lunchPage(driver);
        lunchObject.clickOnProceedButton();
*/
        userHomeObject = new userHomePage(driver);
        userHomeObject.clickOnInternalTransfer();
        userHomeObject.clickOnInboxButton();

        Thread.sleep(3000);
        inBoxObject = new inBoxPage(driver);
        inBoxObject.OpenTransferDetails(entreTransferAccountTest.transferId);
        Thread.sleep(2000);

        internalTransferDetailsObject = new internalTransferDetailsPage(driver);
        internalTransferDetailsObject.clickOnApprovedButton();
        Thread.sleep(1500);
        internalTransferDetailsObject.enterNotes("sdfdsfdsfdsdsf");
        internalTransferDetailsObject.clickOnApprovedBtnFromPopup();
        Thread.sleep(1500);
        internalTransferDetailsObject.clickOnBackInboxButton();
        Thread.sleep(1000);
        //inBoxObject.clickInternalTransfer();
        inBoxObject.clickOnTransferTypeLink();
        Thread.sleep(2000);
        inBoxObject.clickOnInternalTransfer();
        Thread.sleep(1500);

        internalTransferObject = new InternalTransferPage(driver);
        internalTransferObject.getTransferStatus(entreTransferAccountTest.transferId);
        internalTransferObject.refreshPageUntilStatusChange("تمت",driver,entreTransferAccountTest.transferId);

        Thread.sleep(3000);
    }
}
