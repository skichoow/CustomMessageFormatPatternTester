package com.icuformatter.pl;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Locale;

@Service
public class FormatterService {

    @Autowired
    private MessageSource messageSource;

    public String getFormattedMessage(String value, String pattern){
        int parsedValue = Integer.parseInt(value);
        String message = "";
        if(StringUtils.isNotBlank(pattern)){
            message += "<b>By Custom Pattern: </b><br>";
            for (int valueToIncrement = 0; valueToIncrement < parsedValue; valueToIncrement++) {
                message += MessageFormat.format(pattern, valueToIncrement) + "<br>";
            }
        }else {
            for (int valueToIncrement = 0; valueToIncrement < parsedValue; valueToIncrement++) {
                message += messageSource.getMessage("minutes-ago", ArrayUtils.toArray(valueToIncrement), LocaleUtils.toLocale("pl")) + "<br>";
            }
        }
        return message;
    }
}
