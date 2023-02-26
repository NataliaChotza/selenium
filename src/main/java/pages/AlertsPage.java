package pages;

import base.BaseForm;
import elements.Button;
import elements.Li;
import org.openqa.selenium.By;
import browser.BrowserFactory;

import org.slf4j.Logger;
import utilities.ConfigUtils;
import utilities.LoggerUtils;

public class AlertsPage extends BaseForm {
    private static final Logger logger = LoggerUtils.setLoggerClass(AlertsPage.class);

    private static Li alertLiElement = new Li((By.xpath("//div[contains(@class,'show')]//li[contains(@id,'item-1')]")));
    private static Button nestedFramesButton =new Button(By.xpath("//div[contains(@class,'show')]//li[contains(@id,'item-3')]"));

    private static Li browserWindowLi = new Li(By.xpath("//div[contains(@class,'show')]//li[contains(@id,'item-0')]"));




    public static void clickAlertButton(){
        logger.info("Clicked Alert button");
        alertLiElement.click();
    }
    public static void clickNestedFramesButton(){
        logger.info("Clicked Nested Frame button");
        nestedFramesButton.click();

    }
    public static void clickBrowserWindowLi(){
        logger.info("Clicked browser window list");
        browserWindowLi.click();

    }




}
