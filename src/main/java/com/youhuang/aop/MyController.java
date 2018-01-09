package com.youhuang.aop;

import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    
    @Autowired
    private BaseService baseService;

    @RequestMapping("/")
    @ResponseBody
    String home(){
        baseService.test();
        return "hello world!!!111111";
    }
    
    @RequestMapping("/index")
    @ResponseBody
    String index(HttpServletRequest request){
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Entry<String, String[]> entry : parameterMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue()[0]);
        }
        return "index";
    }
}
