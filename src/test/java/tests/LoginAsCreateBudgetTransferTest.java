package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.homePage;
import pages.loginPage;
import pages.lunchPage;
import pages.userHomePage;
import utilities.SetURL;

public class LoginAsCreateBudgetTransferTest extends TestBase{

    lunchPage lunchObject;
    homePage homeObject;
    loginPage loginObject;
    userHomePage userHomeObject;
    
    @Test(priority = 1)
    public void LoginToEtimad() throws InterruptedException {
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
        loginObject.login("1652114222", "P@ssw0rd");

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
        Thread.sleep(3000);
    }
}
