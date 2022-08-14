package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InternalTransferPage extends PageBase{
    public InternalTransferPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='btn btn-primary-light btn-md mr-2']")
    WebElement addNewTransferBtn;

    @FindBy(xpath = "/html/body/header/div[1]/div/div/div[1]/div/ul/li[2]/a")
    public WebElement inboxBtn;

    @FindBy(css = "table.overflow-visible.table.table-expanded.table-bordered.table-striped")
    WebElement table;

    @FindBy(id = "userProfile")
    WebElement userProfileIcon;

    @FindBy(xpath = "//a[@href='/Account/Logout']")
    WebElement logoutBtn;

    public String status;
    public void clickOnAddNewTransfer(){
        clickButton(addNewTransferBtn);
    }

    public void getTransferStatus(String transferId){

        List<WebElement> rows = table.findElements(By.tagName("tr"));
       // System.out.println("rows Number : " + rows.size());
        for (WebElement ele : rows.subList( 1, rows.size())){
            List<WebElement> clos = ele.findElements(By.tagName("td"));
             // System.out.println("Cols number : " + clos.size());
           // System.out.println(clos.get(5).getText());
              if(clos.get(0).getText().contains(transferId)){
                  status = clos.get(5).getText();
                  if(status.contains("جاري التحقق")){
                      break;
                  }
                  }
              }
        }

    public void getTransferStatus2(String transferId){

        List<WebElement> rows = table.findElements(By.tagName("tr"));
        //System.out.println("rows Number : " + rows.size());
        for (WebElement ele : rows.subList( 1, rows.size())){
            List<WebElement> clos = ele.findElements(By.tagName("td"));
            //System.out.println("Cols number : " + clos.size());
            //System.out.println(clos.get(5).getText());
            if(clos.get(0).getText().contains(transferId)){
                status = clos.get(5).getText();
                    break;
            }
        }
    }

        public void refreshPageUntilStatusChange(String status2,WebDriver driver,String transferId) throws InterruptedException {


        for(int i =0 ; ;i++) {
            getTransferStatus2( transferId);
            if (status.contains(status2)) {
                System.out.println("transfer status : " + status);
                break;
            }else{
                driver.navigate().refresh();
                Thread.sleep(10000);
            }
        }
        }

        public void clickOnUserProfile(){
        clickButton(userProfileIcon);
    }

        public void logout(){
        clickButton(logoutBtn);
    }

    }

