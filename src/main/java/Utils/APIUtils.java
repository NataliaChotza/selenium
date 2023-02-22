package Utils;

import org.slf4j.Logger;

import java.net.URL;

public class APIUtils {
    private static final Logger logger =  LoggerUtils.setLoggerClass(ConfigUtils.class);


    public static void GET(String url,String res){
        logger.info("loc.APIUtils.class: Method GET");
        URL pageURL = new URL(url+res);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
        http.disconnect();
       /* Response response = fetch(url+ res)
                .then((response) => response.json())
                .then((json) => console.log(json));
    */

    }
}
