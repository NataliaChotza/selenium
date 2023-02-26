package utilities;


import lombok.experimental.UtilityClass;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.BufferedReader;
import java.io.FileReader;
@UtilityClass
public class ReadFileUtils {
    private JSONObject jsonObject;

    public JSONObject getJSONFile(String fileName){

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
