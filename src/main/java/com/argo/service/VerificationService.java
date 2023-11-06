package com.argo.service;

import com.argo.domain.VerificationCode;

public interface VerificationService {
    public String sendCodeToPhone(String phoneNo);
    public boolean verifyCode(VerificationCode code);
}
