package Forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.logging.Logger;

public class CookiesForm extends Form {
    private static final String locator = "//div[contains(@class,'cookies')]";
    private final IButton cookiesButton = getElementFactory().getButton(By.xpath("//div[contains(@class,'cookies')]//button"), "cookies", ElementState.DISPLAYED);

    public CookiesForm(String name) {
        super(By.xpath(locator), name);
    }

    public void acceptCookies() {
        getLogger().info("Clicked cookies button in CookieForm class");
        cookiesButton.click();
    }

    public boolean isCookiesClosed() {
        getLogger().info("Checked cookies form state in CookiesForm class");
        return cookiesButton.state().isDisplayed();
    }
}
