package Pages;

import org.openqa.selenium.By;

public interface BasePageInterface {
    By pageIndicator = By.xpath("//div[contains(@class,'page-indicator')]");

    int getPageIndicator(By locator, String name);
}
