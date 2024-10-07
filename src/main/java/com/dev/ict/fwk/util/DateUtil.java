package com.dev.fwk.util;

import java.util.Date;
import java.util.Locale;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DateUtil {

    public static String getCurrentTime() {
        return getCurrentTime("yyyy-MM-dd HH:mm:ss.SSS");
    }
    public static String getCurrentTime(String format) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormat.forPattern(format).withLocale(Locale.KOREA);
        return now.toString(fmt);
        
    }
    
    public static Date getCurrentDateTime() {
        return LocalDateTime.now().toDate();
    }
}