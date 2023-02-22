package Utils;

import lombok.experimental.UtilityClass;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;

import java.util.Iterator;

@UtilityClass
public class ConfigUtils {

    static final String CONFIGFILE = "Config.json";
    private static final Logger logger =  LoggerUtils.setLoggerClass(ConfigUtils.class);
    public static JSONArray getConfigData(){
        JSONObject jsonObject=ReadFileUtils.getJSONFile(CONFIGFILE);
        return (JSONArray) jsonObject.get("config_data");
    }

    public static String getURL(String pageName) {
        logger.info("loc.ConfigUtils.class: Returned page url:");
        String url=null;
        Iterator<JSONObject> iterator = getConfigData().iterator();
        while(iterator.hasNext()){
            url=iterator.next().get(pageName).toString();
        }
        System.out.println(url);
       return url;
    }


}
