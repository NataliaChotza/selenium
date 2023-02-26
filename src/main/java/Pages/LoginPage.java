package Pages;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;


public class LoginPage extends Form implements BasePageInterface {
    private static final String locator = "div[contains(@class,'login-form-with-pw-check')]";
    private static final int LOGIN_PAGE_INDICATOR = 1;



    public LoginPage(String name) {
        super(By.xpath(locator), name);
    }



    public int getLoginPageIndicator() {
        return LOGIN_PAGE_INDICATOR;
    }

    @Override
    public int getPageIndicator(By locator, String name) {
        getLogger().info("Returned page indicator in LoginPage class");
        IButton pageIndicator = getElementFactory().getButton(locator, name, ElementState.DISPLAYED);
        return Integer.parseInt(pageIndicator.getText().split("/")[0].trim());

    }
}
