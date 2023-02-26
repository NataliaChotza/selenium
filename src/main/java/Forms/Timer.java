package Forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.logging.Logger;

public class Timer extends Form {

    private static final String locator = "//div[contains(@class,'timer')]";
    private final IButton timer = getElementFactory().getButton(By.xpath(locator), "timer", ElementState.DISPLAYED);

    public Timer(String name) {
        super(By.xpath(locator), name);
    }
    public String getTimer() {
        getLogger().info("Returned timer in Timer class");
        return timer.getText();
    }
}
