package pages;

import base.BaseForm;
import elements.Button;
import org.openqa.selenium.By;
import browser.BrowserFactory;

import org.slf4j.Logger;
import utilities.ConfigUtils;
import utilities.LoggerUtils;


public class MainPage extends BaseForm {
    private static final Logger logger = LoggerUtils.setLoggerClass(MainPage.class);

    private static final Button elementsButton =new Button(By.xpath("//div[contains(@class,'category-cards')]//div[1]"));
    private static final Button alertFrameButton =new Button(By.xpath("//div[contains(@class,'category-cards')]//div[3]"));




    public static void clickElementsButton(){
        logger.info("Clicked elements button");
        elementsButton .click();
        }
    public static void clickAlertFrameWindowButton(){
        logger.info("Clicked alert,frame & window button");
        alertFrameButton.click();


    }
}
