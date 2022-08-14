package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class inBoxPage extends PageBase{
    public inBoxPage(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    @FindBy(css = "table.overflow-visible.table.table-expanded.table-bordered.table-striped")
    WebElement table;

    @FindBy(css = "a.nav-link.dropdown")
    WebElement transfersTab;

    @FindBy(css = "ul.sub-menu.custom-drop-menu")
    WebElement transferTypeList;

    List<WebElement> list = transferTypeList.findElements(By.tagName("li"));

    public void OpenTransferDetails(String transferId){
        System.out.println(table.isDisplayed());
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        //System.out.println("Rows Number : " + rows.size());

        for(WebElement ele : rows.subList( 1, rows.size())){
            List<WebElement> clos = ele.findElements(By.tagName("td"));
          //  System.out.println("Cols number : " + clos.size());
            if (clos.get(0).getText().contains(transferId)){
                WebElement viewClo = clos.get(clos.size()-1);
                WebElement viewBtn = viewClo.findElement(By.tagName("button"));
                clickButton(viewBtn);
                break;
            }
        }
    }

    public void clickOnTransferTypeLink(){
        clickButton(transfersTab);
    }

    public void clickOnInternalTransfer(){
        actions
                .moveToElement(list.get(0))
                .click()
                .perform();
    }
    public void clickInternalTransfer() throws InterruptedException {

        actions
                .moveToElement(transfersTab)
                .moveToElement(list.get(0))
                .click()
                .perform();
    }
}
