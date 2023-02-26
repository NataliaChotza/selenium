package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;


public class ChromeDriverD implements IDriver {
    private WebDriver driver;

    @Override
    public WebDriver getDriver() {
            WebDriverManager.chromedriver().setup();
            driver = new org.openqa.selenium.chrome.ChromeDriver();
            driver.manage().window().maximize();

        return driver;
    }
}
