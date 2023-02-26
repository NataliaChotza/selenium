import Utils.ConfigUtils;
import aquality.selenium.browser.AqualityServices;

public class TestSetUp {
    public static void setBrowserSettings(){
        AqualityServices.getBrowser().goTo(ConfigUtils.getURL());
        AqualityServices.getBrowser().maximize();
    }
}
