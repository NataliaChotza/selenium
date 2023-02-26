package Utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@UtilityClass
public class WaitsUtils {
    private WebDriverWait wait = new WebDriverWait(BrowserUtils.getDriver(), Duration.ofMillis(1000));
    private final int WAIT_TIME = 1000;
    private  final int WINDOWNUMBER = 1;
    public void waitForPageToOpen(){
        wait.withTimeout(Duration.ofMillis(WAIT_TIME));
    }

    public void waitForVisibilityOfElement(String location) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(location)));
    }
    public void waitForAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public void waitForNewPageToOpen(){
        wait.until(ExpectedConditions.numberOfWindowsToBe(WINDOWNUMBER));
    }



}
