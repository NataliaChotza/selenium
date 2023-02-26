package utilities;

import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import pages.AlertsFormPage;

import java.nio.charset.Charset;
import java.util.Random;

@UtilityClass
public class StringUtils {
    private static final Logger logger = LoggerUtils.setLoggerClass(StringUtils.class);

    private String randomString;
    public static String generateRandomText(){
        logger.info("Generated random string");
        byte[] array = new byte[10];
        new Random().nextBytes(array);
        randomString=new String(array, Charset.forName("UTF-8"));
        return randomString;
    }
    public static String getLastRandomString(){
        logger.info("Returned last random string");
        return randomString;
    }


}
