package RequestsPages;

import Utils.ConfigUtils;
import Utils.LoggerUtils;
import org.slf4j.Logger;

public class Posts  {
    private static final Logger logger =  LoggerUtils.setLoggerClass(ConfigUtils.class);

    private static final String POSTS = "/posts";
    private static final int POST_ID =1;

    public static String getPosts(){
        logger.info("loc.Posts.class: returned value for posts request");
     return POSTS;
    }
    public static int getPostId(){
        logger.info("loc.Posts.class: returned post id");
        return POST_ID;
    }


}