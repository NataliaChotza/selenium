package pages;

import browser.BrowserFactory;
import elements.Alert;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import utilities.LoggerUtils;
import utilities.StringUtils;
import java.util.List;

public class AlertsFormPage {
    private static final Logger logger = LoggerUtils.setLoggerClass(AlertsFormPage.class);

    private static final Button alertButton = new Button(By.xpath("//button[contains(@id,'alertButton')]"));
    private static final Button confirmButton = new Button(By.xpath("//button[contains(@id,'confirmButton')]"));

    private static final Button divWithConfirmbutton = (Button) confirmButton.getElement(By.xpath("//parent::div//parent::div[@class,'mt-4']"));
    //new Button(By.xpath("//div[contains(@id,'javascriptAlertsWrapper')]//div[3]"));
    private static final Button divWithPromptButton = new Button(By.xpath("//div[contains(@id,'javascriptAlertsWrapper')]//div[4]"));

    private static final List<WebElement>confirmSpanList = divWithConfirmbutton.getElementList(By.xpath("//span"));

    private static final List<WebElement>promptSpanList = divWithPromptButton.getElementList(By.xpath("//span"));
    private static final Button promtButton = new Button(By.xpath("//button[contains(@id,'promtButton')]"));

    Alert alert;
    public static void clickAlertButton(){
        logger.info("Clicked alert button");
        alertButton.click();
    }

    public static void clickConfirmButton(){
        logger.info("Clicked confirm button");
        confirmButton.click();
    }
    public static Alert getAlert(){
        return new Alert();
    }

    public static String getConfirmSpanText(){
        logger.info("Returned confirm text");
        return confirmSpanList.get(1).getText();
    }
    public static String getPromptSpanText(){
        logger.info("Returned prompt text");
        return promptSpanList.get(1).getText();
    }

    public static void clickPromptButton(){
        logger.info("Clicked prompt button");
        promtButton.click();

    }
    public static void sendTextToAlert(){
        logger.info("Text sent to alert");
        Alert alert = new Alert();
        alert.getAlert().sendKeys(StringUtils.generateRandomText());
    }
    public static boolean isAlertClose(){
        logger.info("Closed alert");
        try{
            BrowserFactory.getDriver().switchTo().alert();
            return true;
        }catch (NoAlertPresentException ex){
            return true;
        }
    }


}
