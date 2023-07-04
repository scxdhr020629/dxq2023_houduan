package com.example.testjpa.utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class DateUtils {
    public static int yearsBetween(Date startDate, Date endDate) {
        LocalDate startLocalDate = new java.sql.Date(startDate.getTime()).toLocalDate();
        LocalDate endLocalDate = new java.sql.Date(endDate.getTime()).toLocalDate();
        return Period.between(startLocalDate, endLocalDate).getYears();
    }
}
