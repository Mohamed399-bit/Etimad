package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InternalTransferPage;
import pages.applyTransferPage;
import pages.enterTransferDetailsPage;
import pages.loginPageAfterLogoutPage;

public class entreTransferAccountTest extends TestBase{

    public static String amountValue = "50";
    public static int entityID = 3;
    public static int accountType = 1;
    public static String transferId;

    enterTransferDetailsPage enterTransferDetailsObject;
    applyTransferPage applyTransferObject;
    InternalTransferPage internalTransferObject;
    loginPageAfterLogoutPage loginPageAfterLogoutObject;

    @Test(priority = 3)

    public void enterAccountDetails() throws InterruptedException {

        enterTransferDetailsObject = new enterTransferDetailsPage(driver);
        enterTransferDetailsObject.clickOnTransferFrom();
        //Thread.sleep(3000);
        enterTransferDetailsObject.selectEntity(entityID);
        //Thread.sleep(3000);
        enterTransferDetailsObject.SelectAccountType(accountType);
       // Thread.sleep(3000);
        enterTransferDetailsObject.SelectAccountNumber(1);
        //Thread.sleep(3000);
        enterTransferDetailsObject.SearchAboutAccount();
        //Thread.sleep(3000);
        enterTransferDetailsObject.enterTransferValue(amountValue);
        //Thread.sleep(3000);
        enterTransferDetailsObject.clickOnTransferTO();
        //Thread.sleep(3000);
        enterTransferDetailsObject.selectEntity(entityID);
        //Thread.sleep(3000);
        enterTransferDetailsObject.SelectAccountType(accountType);
       // Thread.sleep(3000);
        enterTransferDetailsObject.SelectAccountNumber(2);
        //Thread.sleep(3000);
        enterTransferDetailsObject.SearchAboutAccount();
        //Thread.sleep(3000);
        enterTransferDetailsObject.enterTransferValue(amountValue);
        //Thread.sleep(3000);
        enterTransferDetailsObject.clickOnSaveAndNext();
        Thread.sleep(1500);

        applyTransferObject = new applyTransferPage(driver);
        applyTransferObject.clickOnApplyTransfer();
        Thread.sleep(1500);
        applyTransferObject.clickOnApplyTransferFromConfirmationPopup();
        Thread.sleep(2500);
        applyTransferObject.getTransferId();
        transferId = applyTransferObject.getTransferId2();
        applyTransferObject.returnToRequestList();

        internalTransferObject = new InternalTransferPage(driver);
        Assert.assertTrue(internalTransferObject.inboxBtn.isDisplayed());
        System.out.println(internalTransferObject.inboxBtn.getText());

        Thread.sleep(1500);
        internalTransferObject.getTransferStatus(transferId);
        internalTransferObject.refreshPageUntilStatusChange("تحت الاجراء",driver,transferId);

        Thread.sleep(1000);
        internalTransferObject.clickOnUserProfile();
        Thread.sleep(1000);
        internalTransferObject.logout();
        Thread.sleep(1500);
        loginPageAfterLogoutObject = new loginPageAfterLogoutPage(driver);
        loginPageAfterLogoutObject.clickOnLoginButton();
        Thread.sleep(3000);
    }
}
