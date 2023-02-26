package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriver implements IDriver {
    private  WebDriver driver;
    @Override
    public  WebDriver getDriver() {
        if(driver ==null){
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
            driver = new FirefoxDriver();

        }
        return driver;
    }
}
