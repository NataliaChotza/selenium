package pages;

import elements.Li;
import org.openqa.selenium.By;
import browser.BrowserFactory;

import org.slf4j.Logger;
import utilities.ConfigUtils;
import utilities.LoggerUtils;

public class ElementsPage {
    private static final Logger logger = LoggerUtils.setLoggerClass(ElementsPage.class);

    private static Li webTablesButton = new Li(By.xpath("//li[contains(@id,'item-3')and contains(@class,'btn')]"));
    public static void clickWebTablesButton(){
        LoggerUtils.info("Clicked Web table button");
        webTablesButton.click();
    }




}
