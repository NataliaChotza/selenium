import Utils.BrowserUtils;
import Utils.ConfigUtils;
import Utils.LoggerUtils;
import Utils.WaitsUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

public class TestSetUp {
    static WebDriver driver;
    private static final Logger logger =  LoggerUtils.setLoggerClass(ConfigUtils.class);
    private static final String BROWSERNAME = "chrome";

    public static void setBrowserSettings(String pageURL){
        logger.info("loc.TestSetUp.class: Browser settings set");
        driver = BrowserUtils.setBrowserDriver(BROWSERNAME);
        BrowserUtils.setCurrentURL(pageURL);
        WaitsUtils.waitForPageToOpen();
    }
}
