package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    // closing the access to the object of this class from outside the class
    private Driver(){
    }
    // close access from outside the class, static because we will use it inside static method
    //private static WebDriver driver;
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    public static WebDriver getDriver(){
        // checks if driver is null - will set up browser inside if statement, if it is set up (not null), it will return the same driver
        if(driverPool.get() == null){
            // reading BrowserType from configuration.properties and ConfigurationReader class
            String browserType = ConfigurationReader.getProperty("browser");
            switch(browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        return driverPool.get();
    }

    public static void closeDriver(){
        if(driverPool.get() != null){ // terminate the existing driver session, making sure driver is null after quit.
           driverPool.get().quit();
           driverPool.remove();
        }
    }
}
