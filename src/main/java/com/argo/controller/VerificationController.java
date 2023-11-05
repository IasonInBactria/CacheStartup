package com.argo.controller;


import com.argo.service.VerificationService;
import com.argo.service.impl.VerificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/verify")
public class VerificationController {

    @Autowired
    VerificationService verificationService;

    public String getCode(String phoneNo){
        String curCode = verificationService.sendCodeToPhone(phoneNo);
        return curCode;
    }

    public boolean verifyCode(String code){
        verificationService.verifyCode(code);
        return false;
    }

}
