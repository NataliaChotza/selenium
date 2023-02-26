package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import browser.BrowserFactory;

import java.util.List;

public abstract class BaseElement  {
    //concept for all elements
    private WebElement webElement;


    public BaseElement(By locator){
        webElement = BrowserFactory.getDriver().findElement(locator);
    }


    public void click(){
        new Actions(BrowserFactory.getDriver())
                .click(webElement)
                        .perform();
    }

    public WebElement getElement(By locator){
        return webElement.findElement(locator);
    }
    public String getText(){
        return webElement.getText();
    }
    public boolean isDisplayed(){
        return webElement.isDisplayed();
    }
    public List<WebElement> getElementList(By locator) {
        return webElement.findElements(locator);
    }
    public void sendText(String text){
        if(text==null)
            text="";
        webElement.sendKeys(text);
    }

}
