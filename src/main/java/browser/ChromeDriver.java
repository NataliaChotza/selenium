package browser;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class ChromeDriver implements IDriver {
    private  WebDriver driver;



    @Override
    public WebDriver getDriver() {
        if(driver==null)
            WebDriverManager.chromedriver().setup();
            driver = new org.openqa.selenium.chrome.ChromeDriver();

        return driver;
    }
}
