package MercedesCodeChallenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver==null){
            System.setProperty("webdriver.chrome.driver",  System.getProperty("user.dir") + "/src/test/java/driver/geckodriver.exe");
            driver=new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver closeDriver(){

        if(driver!=null){
            driver.quit();
            driver=null;
        }

        return driver;
    }
}