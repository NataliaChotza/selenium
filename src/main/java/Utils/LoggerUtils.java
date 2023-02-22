package Utils;

import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@UtilityClass
public class LoggerUtils {
    private static Logger logger;

    public Logger setLoggerClass(Class loggerClass){
        logger=LoggerFactory.getLogger(loggerClass);
        return logger;
    }
    public void debug(String s,Object o){
        logger.debug(s,o);
    }
    public void info(String s){
        logger.info(s);
    }
    public void error(String s){
        logger.error(s);
    }



}
