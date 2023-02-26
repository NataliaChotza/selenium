package browser;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import utilities.LoggerUtils;

import java.util.ArrayList;


@UtilityClass
final public class BrowserFactory {
    private static final Logger logger = LoggerUtils.setLoggerClass(BrowserFactory.class);
    private WebDriver driver;

    public static WebDriver setBrowserDriver(String browserType) {
        logger.info("The browser driver has been set");
        if(driver==null) {
            if (browserType.equalsIgnoreCase(String.valueOf(BrowserTypes.FIREFOX))) {
                driver = new FireFoxDriverD().getDriver();
                return driver;
            } else if (browserType.equalsIgnoreCase(String.valueOf(BrowserTypes.CHROME))) {
                driver = new ChromeDriverD().getDriver();
                return driver;
            }
        }else{
            return driver;
        }
        return null;
    }

    public static WebDriver getDriver(){
        return driver;
    }
    public static void setCurrentURL(String url) {
        logger.info("Page is set");
        driver.get(url);
    }
    public static ArrayList<String> getPages(){
        return new ArrayList<>(BrowserFactory.getDriver().getWindowHandles());
    }
}
