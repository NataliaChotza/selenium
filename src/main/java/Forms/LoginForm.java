package Forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;


public class LoginForm extends Form {
    private static final String locator = "//div[contains(@class,'login-form__field-row')]//input";

    private final List<ITextBox> textBoxList = getElementFactory().findElements(By.xpath("//div[contains(@class,'align__cell')]//input"), ElementType.TEXTBOX);
    private final ITextBox txbPassword = getElementFactory().getTextBox(By.xpath("//div[contains(@class,'login-form__field-row')]//input"), "password");

    private final IButton dropDown = getElementFactory().getButton(By.xpath("//div[contains(@class,'dropdown')]"), "dropdown");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//a[contains(@class,'button--secondary')]"), "nextButton", ElementState.DISPLAYED);

    private final ICheckBox checkBox = getElementFactory().getCheckBox(By.xpath("//span[contains(@class,'checkbox__check')]"), "", ElementState.DISPLAYED);

    private final String dropdownList = "//div[contains(@class,'dropdown__list-item')]";
    private final String EMAIL_BOX = "Your email";
    private final String DOMAIN_BOX = "Domain";

    public LoginForm(String name) {
        super(By.xpath(locator), name);
    }

    public ITextBox getDomainField() {
        getLogger().info("Set domain in LoginForm class");
        for (ITextBox tb : textBoxList) {
            if (tb.getAttribute("placeholder").matches(DOMAIN_BOX))
                return tb;
        }
        return null;
    }

    public ITextBox getPasswordField() {
        return txbPassword;
    }
    public ITextBox getEmailField(){
        for (ITextBox tb : textBoxList) {
            if (tb.getAttribute("placeholder").matches(EMAIL_BOX))
                return tb;
        }
        return null;
    }

    public List<IButton> getDropDownValues() {
        getLogger().info("Set drop down value in LoginForm class");
        dropDown.click();
        dropDown.state().waitForDisplayed();
        return getElementFactory().findElements(By.xpath(dropdownList), ElementType.BUTTON);

    }
    public void clickNextButton() {
        getLogger().info("Clicked next button in LoginPage class");
        nextButton.click();
    }

    public void uncheckTermsCond() {
        getLogger().info("Uncheck terms and Conditions LoginPage class");
        checkBox.check();

    }
}
