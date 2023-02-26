package Pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.localization.ILocalizedLogger;
import aquality.selenium.core.logging.Logger;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {
    private static final String locator = "//div[contains(@class,'start')]";
    private final ILink LINK_ON_MAIN_PAGE = getElementFactory().getLink(By.xpath("//a[contains(@class,'start__link')]"), "link", ElementState.DISPLAYED);
    private final ILocalizedLogger logger =AqualityServices.getLocalizedLogger();

    public MainPage(String name) {
        super(By.xpath(locator), name);
    }

    public void clickLink() {
        logger.info("Clicked link");
        LINK_ON_MAIN_PAGE.click();
        AqualityServices.getConditionalWait();

    }

    public boolean isPageOpen() {
        getLogger().info("Checked if mainPage is open");
        return this.state().isDisplayed();
    }
}
