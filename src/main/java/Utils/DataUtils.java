package Utils;

import lombok.experimental.UtilityClass;
import org.slf4j.Logger;

@UtilityClass
public class DataUtils {
    private static final Logger logger =  LoggerUtils.setLoggerClass(ConfigUtils.class);


    public static void getResource(String res){
        //AqualityServices.getLogger().info("Returned data");
       // return ConfigUtils.getData().getValue(res).toString();

    }
    public static String getPageURL(String pageURL){
        logger.info("loc.DataUtil.class: returned page url");
        return ConfigUtils.getURL(pageURL);
    }

}
