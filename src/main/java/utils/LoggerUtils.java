package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.LogManager;

public class LoggerUtils {

    public static Logger createLogger (Class clazz ) {
        return LoggerFactory.getLogger(clazz);
    }
}
