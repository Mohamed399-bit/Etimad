/*
 * Copyright (c) INTELLISC 2020.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 23/06/2020 - Script created.
 */
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static String downloadPath = System.getProperty("user.dir") + "\\Downloads";

    public static ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        chromePrefs.put("download.prompt_for_download", false);
       // chromePrefs.put("download.directory_upgrade", false);
        chromePrefs.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs", chromePrefs);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        return options;
    }

    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
            driver = new ChromeDriver(chromeOption());
        } else if (browser.equalsIgnoreCase("opera")) {
            System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "\\drivers\\operadriver.exe");
            driver = new OperaDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome-headless")){

            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("https://10.14.8.2:8055/Account/Login");
    }

    @AfterSuite
    public void closeDriver() {
        //driver.quit();
    }

    //take screenshot when test case failed and add it in the Screenshots folder
    @AfterMethod
    public void screenShotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed");
            System.out.println("Taking Screenshot....");
           // Helper.captureScreenShot(driver, result.getName());
        }
    }
}
