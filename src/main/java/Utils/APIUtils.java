package Utils;

import org.slf4j.Logger;

public class APIUtils {
    private static final Logger logger =  LoggerUtils.setLoggerClass(ConfigUtils.class);


    public static void GET(String url,String res){
        logger.info("loc.APIUtils.class: Method GET");
       /* Response response = fetch(url+ res)
                .then((response) => response.json())
                .then((json) => console.log(json));
    */
        System.out.println("ok");
    }
}
