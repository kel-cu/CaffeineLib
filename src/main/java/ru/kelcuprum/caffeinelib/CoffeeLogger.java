package ru.kelcuprum.caffeinelib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

public class CoffeeLogger {
    public final String name;
    public final String logName;
    public final Logger logger;
    public CoffeeLogger(String name){
        this.name = name;
        this.logName = String.format("[%s] ", this.name);
        this.logger = LoggerFactory.getLogger(this.name);
    }
    public void log(Level level, String msg){
        switch (level) {
            case INFO -> logger.info("{}{}", this.logName, msg);
            case WARN -> logger.warn("{}{}", this.logName, msg);
            case ERROR -> logger.error("{}{}", this.logName, msg);
            case DEBUG -> logger.debug("{}{}", this.logName, msg);
            case TRACE -> logger.trace("{}{}", this.logName, msg);
        }
    }

    public void log(String msg){
        log(Level.INFO, msg);
    }

    public void log(Level level, String msg, Object ...objects){
        log(level, String.format(msg, objects));
    }

    public void log(String msg, Object ...objects){
        log(Level.INFO, String.format(msg, objects));
    }


    public void error(String msg, Object ...objects){
        log(Level.ERROR, String.format(msg, objects));
    }
    public void error(String msg){
        log(Level.ERROR, msg);
    }

    public void debug(String msg, Object ...objects){
        log(Level.DEBUG, String.format(msg, objects));
    }
    public void debug(String msg){
        log(Level.DEBUG, msg);
    }

    public void warn(String msg, Object ...objects){
        log(Level.WARN, String.format(msg, objects));
    }
    public void warn(String msg){
        log(Level.WARN, msg);
    }

    public void fatal(String msg, Object ...objects){
        log(Level.ERROR, String.format(msg, objects));
    }
    public void fatal(String msg){
        log(Level.ERROR, msg);
    }
}
