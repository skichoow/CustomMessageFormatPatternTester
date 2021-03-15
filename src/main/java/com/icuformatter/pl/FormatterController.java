package com.icuformatter.pl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/formatter")
public class FormatterController {

    @Autowired
    FormatterService service;

    @GetMapping("/format/{value}")
    public String getFormattedMessage(@PathVariable String value){
        return service.getFormattedMessage(value, "");
    }

    @GetMapping("/format/{value}/{pattern}")
    public String getFormattedMessage(@PathVariable String value, @PathVariable String pattern){
        return service.getFormattedMessage(value, pattern);
    }
}
