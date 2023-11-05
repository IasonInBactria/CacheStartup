package com.argo.service.impl;


import com.argo.service.VerificationService;
import com.argo.service.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class VerificationServiceImpl implements VerificationService {

    @Autowired
    public CodeUtils codeUtils;
    @Override
    //@Cacheable(value = "VerificationCode", key = "#phoneNo")
    @CachePut(value = "VerificationCode", key = "#phoneNo")
    public String sendCodeToPhone(String phoneNo) {
        String code = codeUtils.generator(phoneNo);
        return code;
    }

    @Override
    public boolean verifyCode(String code) {
        return false;
    }
}
