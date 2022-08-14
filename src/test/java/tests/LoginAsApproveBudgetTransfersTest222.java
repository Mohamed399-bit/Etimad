package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.SetURL;

public class LoginAsApproveBudgetTransfersTest222 extends TestBase{

    lunchPage lunchObject;
    homePage homeObject;
    loginPage loginObject;
    userHomePage userHomeObject;
    inBoxPage inBoxObject;
    
    @Test(priority = 4)
    public void LoginToEtimadAsApproveBudgetTransfers() throws InterruptedException {
       /*
        lunchObject = new lunchPage(driver);
        lunchObject.clickOnAdvancedButton();
        Thread.sleep(1000);
        lunchObject.clickONProceedLink();
        */

        homeObject = new homePage(driver);
        Thread.sleep(1000);
        homeObject.clickOnEntityGov();

        loginObject = new loginPage(driver);
        loginObject.login("1016892265", "P@ssw0rd");

       String UrlBase =  driver.getCurrentUrl();
       Thread.sleep(2000);
       
        System.out.println(UrlBase);

        Thread.sleep(2000);
        SetURL.lunch();
        lunchObject = new lunchPage(driver);
        lunchObject.clickOnProceedButton();

        userHomeObject = new userHomePage(driver);

        Assert.assertTrue(userHomeObject.inboxBtn.isDisplayed());
        System.out.println(userHomeObject.inboxBtn.getText());
        Thread.sleep(1500);
        userHomeObject = new userHomePage(driver);
        userHomeObject.clickOnInternalTransfer();
        userHomeObject.clickOnInboxButton();

        Thread.sleep(1500);
        inBoxObject = new inBoxPage(driver);
        inBoxObject.clickOnTransferTypeLink();
        Thread.sleep(1500);
        inBoxObject.clickOnInternalTransfer();
        Thread.sleep(1500);
    }
}
