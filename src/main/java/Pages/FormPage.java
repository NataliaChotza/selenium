package Pages;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class FormPage extends Form implements BasePageInterface {

    private static final String locator = "//div[contains(@class,'personal-details')]";
    private static final int FORM_PAGE_INDICATOR = 3;
    public FormPage(String name) {
        super(By.xpath(locator), name);
    }
    public int getFormPageIndicator(){
        getLogger().info("Returned page indicator");
        return FORM_PAGE_INDICATOR;
    }

    @Override
    public int getPageIndicator(By locator, String name) {
        getLogger().info("Returned Page indicator in FormPage class");
        IButton pageIndicator = getElementFactory().getButton(locator, name, ElementState.DISPLAYED);
        return Integer.parseInt(pageIndicator.getText().split("/")[0].trim());

    }
}
