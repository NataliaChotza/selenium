package RequestsPages;

import Utils.ConfigUtils;
import Utils.LoggerUtils;
import org.slf4j.Logger;

public class Posts  {
    private static final Logger logger =  LoggerUtils.setLoggerClass(ConfigUtils.class);

    private static final String POSTS = "/posts";

    public static String getPosts(){
     return POSTS;
    }

}