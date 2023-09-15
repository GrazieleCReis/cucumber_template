package com.templatecucumber.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager(){}

    public static WebDriver getDriver(){
        if(driver == null){
            switch (Config.browser){
                case CHROME -> driver = new ChromeDriver(getOptions());
                case FIREFOX-> driver = new FirefoxDriver();
            }
            driver.manage().window().setSize(new Dimension(1200,765));
        }
        return driver;
    }

    public static void waitImplicit(Integer seconds){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public static void killDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
    public static ChromeOptions getOptions() {
        var chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--log-level=OFF");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--disable-dev-shm-usage");

        if (Config.BROWSER_HEADLESS) chromeOptions.addArguments("--headless=new");
        return chromeOptions;
    }
}