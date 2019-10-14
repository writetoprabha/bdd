package com.seleniumcucumber.webdriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.seleniumcucumber.reports.ExtentManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.*;
public class WebConnector {
    public WebDriver driver;
    public Properties projectProperties,
    runTestProperties;
    public WebDriverWait wait;
    public ExtentReports reporter;
    public ExtentTest scenarioLog;

    public WebConnector() throws IOException {
        loadProperties();
        switch (runTestProperties.getProperty("browser")) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
                driver = new ChromeDriver();
                break;
            default:
                System.out.println("Unable to open browser");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    public void loadProperties() throws IOException {
        if(runTestProperties == null){
            FileInputStream fis;
            runTestProperties = new Properties();
            try{
                fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Properties/runTest.properties");
                runTestProperties.load(fis);
                System.out.println("runTestProperties are loaded successfully");
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            } finally {
                fis = null;
            }

            try{
                fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Properties/project.properties");
                projectProperties = new Properties();
                projectProperties.load(fis);
                System.out.println("projectProperties are loaded successfully");
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            } finally {
                fis = null;
            }
        }
    }

    public void click(String elementReference){
        getObject(elementReference).click();
    }

    public void enterText(String elementReference, String textValue){
        WebElement e = getObject(elementReference);
        if(e != null) {
            e.sendKeys(textValue);
        } else {
            System.out.println("Unable to locate element " + elementReference);
        }
    }

    public WebElement getObject(String elementReference){

        String elementLocator = projectProperties.getProperty(elementReference);
        if(elementLocator.endsWith("~xpath")) {
            return getElementByXPath(elementLocator.replace("~xpath", ""));
        } else if(elementLocator.endsWith("~css")) {
            return getElementByCss(elementLocator.replace("~css", ""));
        } else if(elementLocator.endsWith("~name")) {
            return getElementByName(elementLocator.replace("~name", ""));
        } else {
            WebElement e = null;
            try{
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementLocator)));
                e = driver.findElement(By.id(elementLocator));
            } catch (Exception ex) {
                reportFailure(ex.getMessage());
            }
            return e;
        }
    }

    public WebElement getElementByCss(String elementReference) {
        WebElement e = null;
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementReference)));
            e = driver.findElement(By.cssSelector(elementReference));
        } catch (Exception ex) {
            reportFailure(ex.getMessage());
        }
        return e;
    }

    public WebElement getElementByName(String elementReference) {
        WebElement e = null;
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(elementReference)));
            e = driver.findElement(By.name(elementReference));
        } catch (Exception ex) {
            reportFailure(ex.getMessage());
        }
        return e;
    }

    public WebElement getElementByXPath(String elementReference) {
        WebElement e = null;
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementReference)));
            e = driver.findElement(By.xpath(elementReference));
        } catch (Exception ex) {
            reportFailure(ex.getMessage());
        }
        return e;
    }

    public void navigate(String siteName) {
        driver.get(projectProperties.getProperty(siteName));
    }

    //******************************Extent Reporting functions******************************************
    public void initializeReports(String scenarioName){
        reporter = ExtentManager.getInstance(System.getProperty("user.dir") + "/test_reports/");
        scenarioLog = reporter.createTest(scenarioName);
    }

    public void infoLog(String logMessage){
        scenarioLog.log(Status.INFO, logMessage);
    }

    public void reportFailure(String logMessage){
        scenarioLog.log(Status.FAIL, logMessage);
        takeScreenShot();
        assertThat(false);
    }

    public void reportSuccess(String logMessage){
        scenarioLog.log(Status.PASS, logMessage);
    }

    public void flushLogs(){
        if(reporter != null) {
            reporter.flush();
        }
    }

    public void takeScreenShot(){
        Date d = new Date();
        String fileName = d.toString().replace(",", "_").replace(":", "_") + ".png";
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(srcFile, new File(ExtentManager.screenShotFolderPath + fileName));
            scenarioLog.log(Status.FAIL, "ScreenShot=> " + scenarioLog.addScreenCaptureFromPath(ExtentManager.screenShotFolderPath + fileName));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
