package Utils;


import lombok.experimental.UtilityClass;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;


import java.io.BufferedReader;
import java.io.FileReader;
@UtilityClass
public class ReadFileUtils {
    private static final Logger logger =  LoggerUtils.setLoggerClass(ConfigUtils.class);

    private JSONObject jsonObject;

    public JSONObject getJSONFile(String fileName){
        logger.info("loc.ReadFileUtils.class: Returned jsonObject");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            JSONParser parser = new JSONParser();
            jsonObject= (JSONObject) parser.parse(reader);
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }

        return jsonObject;

    }

}
