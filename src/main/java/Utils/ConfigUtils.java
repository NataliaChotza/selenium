package Utils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import lombok.experimental.UtilityClass;

import java.util.logging.Logger;

@UtilityClass
public class ConfigUtils {

    static final String CONFIGFILE = "Config.json";
    static final String pageURL = "/mainPage_URL";
    static final String image = "/image";

    public static ISettingsFile getData() {
        AqualityServices.getLogger().info("Returned data");
        ISettingsFile config = new JsonSettingsFile(CONFIGFILE);
        return config;
    }

    public static String getURL() {
        AqualityServices.getLogger().info("Returned url");
        return getData().getValue(pageURL).toString();
    }

    public static String getImage() {
        AqualityServices.getLogger().info("Returned image");
        return getData().getValue(image).toString();
    }
}
