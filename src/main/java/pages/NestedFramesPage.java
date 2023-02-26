package pages;


import elements.Li;
import org.openqa.selenium.*;
import browser.BrowserFactory;
import org.slf4j.Logger;
import org.testng.annotations.DataProvider;
import utilities.ConfigUtils;
import utilities.LoggerUtils;


public class NestedFramesPage {

    private static final Logger logger = LoggerUtils.setLoggerClass(NestedFramesPage.class);

    private static final WebElement iframeParent = BrowserFactory.getDriver().findElement(By.xpath("//iframe[contains(@id,'frame1')]"));
    private static final Li framesButton = new Li(By.xpath("//div[contains(@class,'show')]//li[contains(@id,'item-2')]"));
    private static WebDriver frame= BrowserFactory.getDriver().switchTo().frame(iframeParent);

     private static final WebElement iframeChild = BrowserFactory.getDriver().findElement(By.xpath("//iframe"));


    public static String[] getParentChildFrametext(){
        logger.info("returned parent and child frame text");

        String[] pc= new String [2];
        frame = frame.switchTo().frame(iframeChild);

        String childFrameText = frame.findElement(By.xpath("//body//p")).getText();
        frame =frame.switchTo().parentFrame();
        String parentFrameText = frame.findElement(By.xpath("//body")).getText();
        frame.switchTo().defaultContent();

        pc[0]=parentFrameText;
        pc[1]=childFrameText;


        return pc;


    }
    public static void clickFramesButton(){
        logger.info("Clicedk frames button");
        framesButton.click();

    }


}
