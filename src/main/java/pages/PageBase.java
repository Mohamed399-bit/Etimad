/*
 * Copyright (c) INTELLISC 2020.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 23/06/2020 - Script created.
 */
package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    public JavascriptExecutor jse;
    public Actions actions;
    public WebDriverWait wait;
    public WebDriver driver;

    //Super constructor
    public PageBase(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    protected static void clickButton(WebElement button) {
        button.click();
    }

    protected static void setTextWebElement(WebElement textElement, String value) {
        textElement.sendKeys(value);

    }

    protected static void clearField(WebElement button) {
        button.clear();
    }

    public void convertElementEditable(String elementName) {
        jse.executeScript("arguments[0].removeAttribute('readonly','readonly')", elementName);
    }

    protected void scrollToBottom() {
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        jse.executeScript("scrollBy(0,1500)");
    }

    public void clickOnButtonUsingJavaScript(WebElement ele){
        jse.executeScript("arguments[0].click();", ele);
    }

    public void click(WebElement ele){
        jse.executeScript("arguments[0].click();", ele);
    }


    //you can add below more methods for different types of inputs like checkboxes or dropdown lists and so on
}


