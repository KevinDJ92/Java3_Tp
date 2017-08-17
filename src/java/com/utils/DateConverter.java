package com.utils;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;

public class DateConverter {
     public static final DateTimeZone jodaTzUTC = DateTimeZone.forID("UTC");
     public static final int JANUARY = 1;
     public static final int DECEMBER = 12;
     public static final int FIRST_OF_THE_MONTH = 1;
      
    // from  java.sql.Date  to LocalDate:
    public static LocalDate dateToLocalDate(java.sql.Date d) {
        if(d == null) return null;
        return new LocalDate(d.getTime(), jodaTzUTC);
    }

    // from  LocalDate to java.sql.Date:
    public static java.sql.Date localdateToDate(LocalDate ld) {
        if(ld == null) return null;
        return new java.sql.Date(
             ld.toDateTimeAtStartOfDay(jodaTzUTC).getMillis());
    }
    
    public static final int getLastDayOfMonth(final int month, final int year) {
    int lastDay = 0;

        if ((month >= JANUARY) && (month <= DECEMBER)) {
            LocalDate aDate = new LocalDate(year, month, FIRST_OF_THE_MONTH);

            lastDay = aDate.dayOfMonth().getMaximumValue();
        }

    return lastDay;
    }
}
