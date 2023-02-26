package utilities;

import browser.BrowserFactory;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import pages.MainPage;

@UtilityClass
public class WaitsUtils {
    private static final Logger logger = LoggerUtils.setLoggerClass(WaitsUtils.class);

    private WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), ConfigUtils.getWaitTime());
    private  final int WINDOWNUMBER = 2;

    public void waitForVisibilityOfElement(String location) {
        logger.info("The element is visible");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(location)));
    }
    public void waitForAlert(){
        logger.info("The alert is visible");
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public void waitForNewPageToOpen(){
        logger.info("The new page is opened");
        wait.until(ExpectedConditions.numberOfWindowsToBe(WINDOWNUMBER));
    }



}
