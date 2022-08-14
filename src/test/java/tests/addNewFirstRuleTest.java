package tests;

import org.testng.annotations.Test;
import pages.addNewFirstRulePage;
import pages.adminHomePage;
import pages.firstRulePage;

public class addNewFirstRuleTest extends TestBase{

    adminHomePage adminHomeObject;
    firstRulePage firstRuleObject;
    addNewFirstRulePage addNewFirstRuleObject;

    @Test
    public void addNewRuleForFirstRule() throws InterruptedException {

        adminHomeObject = new adminHomePage(driver);
        adminHomeObject.openTheFirstRule();

        firstRuleObject = new firstRulePage(driver);
        firstRuleObject.clickOnAddNewRule();

        addNewFirstRuleObject = new addNewFirstRulePage(driver);
        addNewFirstRuleObject.selectEntity("022001000000");
        Thread.sleep(1000);
        addNewFirstRuleObject.SelectAccountType("2");
        Thread.sleep(1000);
        addNewFirstRuleObject.SelectAccountNumber("404090100266");
        Thread.sleep(1000);
        addNewFirstRuleObject.SelectTransferWay("3");
        Thread.sleep(1000);
        addNewFirstRuleObject.SelectTransferType("3");
        Thread.sleep(1000);
        addNewFirstRuleObject.selectDates();
        Thread.sleep(1000);
        addNewFirstRuleObject.enterAmountValue("100");
        Thread.sleep(1000);
        addNewFirstRuleObject.enterDocmentData("120","3");
        Thread.sleep(1000);
        addNewFirstRuleObject.clickOnAddNewRule();

        Thread.sleep(8000);





    }
}
