package Utils;

import lombok.experimental.UtilityClass;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
@UtilityClass
public class ConfigUtils {

    static final String CONFIGFILE = "Config.json";
    private static final Logger logger =  LoggerUtils.setLoggerClass(ConfigUtils.class);

    public static String getURL(String pageName) {
        logger.info("loc.ConfigUtils.class: Returned page url:");
       JSONObject jsonObject=ReadFileUtils.getJSONFile(CONFIGFILE);
       return jsonObject.get(pageName).toString();
    }


}
