package com.argo.service.impl;


import com.argo.domain.VerificationCode;
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
    public boolean verifyCode(VerificationCode verificationCode) {
        //取出内存中验证码，与传递的验证码比对
        String code = verificationCode.getCode();
        String cacheCode = getCodeFromCache(verificationCode.getPhoneNo());
        return cacheCode.equals(code);
    }

    @Cacheable(value = "VerificationCode", key = "#phoneNo")
    public String getCodeFromCache(String phoneNo){
        return null;
    }
}
