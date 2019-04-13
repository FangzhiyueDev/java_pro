package com.fang.demo.converter;


import com.sun.org.apache.bcel.internal.generic.FADD;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * spring的转换器
 */

public class MyConverter implements Converter<String, Date> {


    private String dateFormat;

    public MyConverter(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public Date convert(String s) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        simpleDateFormat.setLenient(false);

        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
