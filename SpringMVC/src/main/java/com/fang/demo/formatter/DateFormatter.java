package com.fang.demo.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter implements Formatter<Date> {


    private String dateFormat;
    private SimpleDateFormat sdf;


    public DateFormatter(String dateFormat) {
        this.dateFormat = dateFormat;
        sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
    }

    /**
     * 将string转换为Date
     *
     * @param s
     * @param locale
     * @return
     * @throws ParseException
     */
    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        return sdf.parse(s);
    }

    /**
     * 将date转换为String
     *
     * @param date
     * @param locale
     * @return
     */
    @Override
    public String print(Date date, Locale locale) {
        return sdf.format(date);
    }
}
