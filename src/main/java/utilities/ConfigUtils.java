package utilities;

import lombok.experimental.UtilityClass;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.time.Duration;
import java.util.Iterator;
@UtilityClass
public class ConfigUtils {

    private final String CONFIGFILE = "ConfigData.json";

    public static JSONArray getConfigFileData() {
        JSONObject jsonObject = ReadFileUtils.getJSONFile(CONFIGFILE);
        JSONArray jsonArray = (JSONArray) jsonObject.get("config_data");
        return jsonArray;
    }

    public String getURL(String variableName) {
        String url = null;
        Iterator<org.json.simple.JSONObject> iterator = getConfigFileData().iterator();
        while (iterator.hasNext()) {
            url = iterator.next().get(variableName).toString();
        }
        return url;

    }


    public Duration getWaitTime() {
        Duration waitTime = null;
        Iterator<org.json.simple.JSONObject> iterator = getConfigFileData().iterator();
        while (iterator.hasNext()) {
            waitTime = Duration.ofMillis(Long.parseLong(iterator.next().get("wait_time").toString()));
        }
        return waitTime;
    }
}