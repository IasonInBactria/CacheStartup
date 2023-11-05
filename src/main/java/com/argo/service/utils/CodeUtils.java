package com.argo.service.utils;

import org.springframework.stereotype.Component;

import static java.lang.Math.abs;


@Component
public class CodeUtils {
    public String generator(String phoneNo){
        int hash =  phoneNo.hashCode();
        int encryption = 202316666;
        long curTime = System.currentTimeMillis();
        int result  = abs((int) (hash ^ encryption ^ curTime));
        return (String.format("%06d", result % 1000000));
    }

}
