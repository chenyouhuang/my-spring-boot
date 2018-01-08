package com.youhuang.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "hello world!!!111111";
    }
}
