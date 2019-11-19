package com.nhfc99.template.Config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {
    @Nullable
    @Override
    public Date convert(String json) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse((String) json);
        } catch (Exception e) {
            SimpleDateFormat sdfday = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = sdfday.parse((String) json);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        }
        return date;
    }
}
