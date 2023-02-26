package base;

import browser.BrowserFactory;
import org.openqa.selenium.Alert;
import org.slf4j.Logger;
import pages.AlertsPage;
import utilities.LoggerUtils;

public abstract class BaseForm {
    // concept for all pages with alerts
    private static final Logger logger = LoggerUtils.setLoggerClass(BaseForm.class);
    private static Alert alert;
    public  String getAlertText(){
        return this.alert.getText();
    }

    public Alert getAlert() {
        return alert;
    }


    public void moveToAlert(){
        logger.info("Switched to the alert");
        this.alert= BrowserFactory.getDriver().switchTo().alert();

    }
    public static void closePage(int index){
        logger.info("Closed window");
        moveToPage(index);
        BrowserFactory.getDriver().close();

    }
    public static void moveToPage(int index){
        logger.info("Moved to window with index"+index);
        BrowserFactory.getDriver().switchTo().window(BrowserFactory.getPages().get(index));
    }
    public void clickOkButton(){
        logger.info("Clicked OK button");
        this.alert.accept();
    }

}
