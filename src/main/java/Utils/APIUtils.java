package Utils;

import org.slf4j.Logger;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class APIUtils {
    private static final Logger logger =  LoggerUtils.setLoggerClass(ConfigUtils.class);


    public static HttpURLConnection GET(String url,String res)  {
        logger.info("loc.APIUtils.class: Method GET");
        HttpURLConnection http=null;
        try{
        URL pageURL = new URL(url+res);
        http = (HttpURLConnection)pageURL.openConnection();
        http.disconnect();
        }catch(Exception ex){
            System.err.println(ex.getMessage());

        }
        return http;
    }
    public static int getResponseCode(String url,String res){
        int responseCode = 0;
        try{
            responseCode=GET(url,res).getResponseCode();
        }catch (IOException ex){
            System.err.println(ex.getMessage());
        }
        return responseCode;
    }
    public static void getRequestData(String url,String res){

    }

}
