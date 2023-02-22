package Utils;

import browser.BrowserTypes;
import browser.ChromeDriver;
import browser.FireFoxDriver;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

@UtilityClass
final public class BrowserUtils {
    WebDriver driver;

    public static WebDriver setBrowserDriver(String browserType) {
        if (browserType.equalsIgnoreCase(String.valueOf(BrowserTypes.FIREFOX))) {
            driver= new FireFoxDriver().getDriver();
            return driver;
        } else if (browserType.equalsIgnoreCase(String.valueOf(BrowserTypes.CHROME))) {
            driver= new ChromeDriver().getDriver();
            return driver;
        }
        return null;
    }

    public static WebDriver getDriver(){
        return driver;
    }
    public static void setCurrentURL(String url){
        driver.get(url);
    }
    public static ArrayList<String> getPages(){
        return new ArrayList<>(BrowserUtils.getDriver().getWindowHandles());
    }
}
