package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import browser.BrowserFactory;


public class FramePage {
        private static final WebElement iframe1 = BrowserFactory.getDriver().findElement(By.xpath("//iframe[contains(@id,'frame1')]"));
        private static final WebElement iframe2 = BrowserFactory.getDriver().findElement(By.xpath("//iframe[contains(@id,'frame2')]"));
        private static WebDriver frame = BrowserFactory.getDriver();
        public static String getIFrameContent(int iframeID){
            WebElement elementFrame=null;
            if(iframeID==1) {
                elementFrame = iframe1;
            }else if(iframeID==2) {
                elementFrame = iframe2;
            }
            frame=frame.switchTo().frame(elementFrame);
            String element = frame.findElement(By.xpath("//h1[contains(@id,'sampleHeading')]")).getText();

            frame.switchTo().defaultContent();

            return element;
        }



}
