package com.argo.controller;


import com.argo.domain.VerificationCode;
import com.argo.service.VerificationService;
import com.argo.service.impl.VerificationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangY
 */
@RestController
@RequestMapping("/verify")
@RequiredArgsConstructor
public class VerificationController {
    private final VerificationService verificationService;

    @GetMapping
    public String getCode(String phoneNo){
        String curCode = verificationService.sendCodeToPhone(phoneNo);
        return curCode;
    }

    @PostMapping
    public boolean verifyCode(VerificationCode code){
        verificationService.verifyCode(code);
        return false;
    }

}
