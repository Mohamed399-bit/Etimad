package tests;

import org.testng.annotations.Test;
import pages.inBoxPage;
import pages.userHomePage;

public class viewTransferTest extends TestBase{

    userHomePage userHomeObject;
    inBoxPage inBoxObject;

    @Test(priority = 2)
    public void ViewTransferDetails() throws InterruptedException {

        userHomeObject = new userHomePage(driver);
        userHomeObject.clickOnInboxButton();

        Thread.sleep(3000);

        inBoxObject = new inBoxPage(driver);
        inBoxObject.OpenTransferDetails("220555002323");

        Thread.sleep(9000);
    }
}
