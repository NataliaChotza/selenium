package pages;

import base.BaseForm;
import elements.Button;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import utilities.LoggerUtils;


public class LinksPage extends BaseForm {
    private static final Logger logger = LoggerUtils.setLoggerClass(LinksPage.class);

    private static Button homeLink = new Button(By.xpath("//div[contains(@id,'linkWrapper')]//p[1]//a"));

    public static void clickHomeLink(){
        logger.info("Clicked Home link");
        homeLink.click();
    }
}
