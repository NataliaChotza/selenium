package pages;

import base.BaseForm;
import elements.Button;
import elements.Li;
import org.openqa.selenium.By;
import browser.BrowserFactory;

import org.slf4j.Logger;
import utilities.ConfigUtils;
import utilities.LoggerUtils;

public class BrowserWindowPage  extends BaseForm {
    private static final Logger logger = LoggerUtils.setLoggerClass(BrowserWindowPage.class);

    private static final Button newTabButton = new Button(By.xpath("//button[contains(@id,'tabButton')]"));

    private static final Button elementsButton = new Button(By.xpath("//div[contains(@class,'accordion')]//div[1]//span[contains(@class,'group-header')]"));

    private static final Li linkLi = new Li(By.xpath("//div[contains(@class,'accordion')]//div[1]//div//li[contains(@id,'item-5')]"));

    public static void clickNewTabButton(){
        logger.info("Clicked new tab button");
        newTabButton.click();

    }
    public static void clickElementsButton(){
        logger.info("Clicked elements button");
        elementsButton.click();
    }
    public static void clickLinksButton(){
        logger.info("Clicked links button");
        linkLi.click();
    }


}
