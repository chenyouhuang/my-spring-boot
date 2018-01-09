package com.youhuang.aop;

import org.springframework.stereotype.Component;

@Component
public class BaseServiceImpl implements BaseService {

    @Override
    public void test() {
        System.out.println("--->BaseServiceImpl");
    }

}
