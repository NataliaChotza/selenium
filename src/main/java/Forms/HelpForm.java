package Forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.logging.Logger;

public class HelpForm extends Form {
    private static final String locator = "//div[contains(@class,'help-form')]";
    private final IButton closeHelpButton = getElementFactory().getButton(By.xpath("//button[contains(@class,'help-form__send-to-bottom-button')]"), "closeHelp", ElementState.DISPLAYED);
    private final IButton divHelp = getElementFactory().getButton(By.xpath("//div[contains(@class,'help-form')]"), "divHelp", ElementState.DISPLAYED);

    public HelpForm(String name) {
        super(By.xpath(locator), name);
    }

    public void closeHelpForm() {
        getLogger().info("Closed help form in HelpForm class");
        closeHelpButton.click();
    }

    public boolean isHelpFormClosed() {
        getLogger().info("Checked help form state in HelpForm class");
        divHelp.state().waitForNotDisplayed();
        return divHelp.state().isDisplayed();
    }

}
