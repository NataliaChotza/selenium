package utilities;

import lombok.experimental.UtilityClass;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@UtilityClass
public class TestDataUtils {
    private String TESTDATA="TestData.json";
    private final String AGE = "age";
    private final String FIRSTNAME = "firstname";
    private final String LASTNAME = "lastname";
    private final String EMAIL ="email";
    private final String SALARY ="salary";
    private final String DEPARTMENT ="department";
    private final String USERNO = "user_no";
    Map<String,String> userMap = new HashMap<>();
    public JSONObject getTestDataFile(){
        JSONObject jsonObject = ReadFileUtils.getJSONFile(TESTDATA);
        return jsonObject;
    }
    public Map<String,String> getUserData(String user){

        JSONArray jsonArray = (JSONArray) getTestDataFile().get(user);
        Iterator<JSONObject> iterator = jsonArray.iterator();
        JSONObject userData = iterator.next();
            userMap.put(FIRSTNAME,userData.get(FIRSTNAME).toString());
            userMap.put(LASTNAME,userData.get(LASTNAME).toString());
            userMap.put(EMAIL,userData.get(EMAIL).toString());
            userMap.put(AGE,userData.get(AGE).toString());
            userMap.put(SALARY,userData.get(SALARY).toString());
            userMap.put(DEPARTMENT,userData.get(DEPARTMENT).toString());

        return userMap;
    }

}
