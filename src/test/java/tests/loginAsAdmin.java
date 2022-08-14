package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.SetURL;

public class loginAsAdmin extends TestBase{
    lunchPage lunchObject;
    homePage homeObject;
    loginPage loginObject;
    adminHomePage adminHomeObject;

    @Test
    public void loginToEtimadAsAdmin() throws InterruptedException {
        homeObject = new homePage(driver);
        Thread.sleep(1000);
        homeObject.clickOnEntityGov();

        loginObject = new loginPage(driver);
        loginObject.login("1070814676", "P@ssw0rd");

        String UrlBase =  driver.getCurrentUrl();
        Thread.sleep(2000);

        System.out.println(UrlBase);

        Thread.sleep(2000);
        SetURL.lunch();
        lunchObject = new lunchPage(driver);
        lunchObject.clickOnProceedButton();

        adminHomeObject = new adminHomePage(driver);
        Assert.assertTrue(adminHomeObject.divComp.isDisplayed());
        adminHomeObject.listSize();
        /*
        userHomeObject = new userHomePage(driver);

        Assert.assertTrue(userHomeObject.inboxBtn.isDisplayed());
        System.out.println(userHomeObject.inboxBtn.getText());
        */
        Thread.sleep(3000);
    }
}
