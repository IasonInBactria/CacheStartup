package com.argo.service;

public interface VerificationService {
    public String sendCodeToPhone(String phoneNo);
    public boolean verifyCode(String code);
}
