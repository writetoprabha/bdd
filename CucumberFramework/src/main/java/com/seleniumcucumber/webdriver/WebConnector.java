package com.seleniumcucumber.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebConnector {
    public WebDriver driver;
    public Properties projectProperties,
    runTestProperties;
    public WebDriverWait wait;

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
            WebElement e;
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementLocator)));
            e = driver.findElement(By.id(elementLocator));
            return e;
        }
    }

    public WebElement getElementByCss(String elementReference) {
        WebElement e = null;
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementReference)));
            e = driver.findElement(By.cssSelector(elementReference));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }

    public WebElement getElementByName(String elementReference) {
        WebElement e = null;
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(elementReference)));
            e = driver.findElement(By.name(elementReference));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }

    public WebElement getElementByXPath(String elementReference) {
        WebElement e = null;
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementReference)));
            e = driver.findElement(By.xpath(elementReference));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }

    public void navigate(String siteName) {
        driver.get(projectProperties.getProperty(siteName));
    }

}
