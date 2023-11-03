package com.argo.service;


public interface MessageService {
    public String get(String phoneNo);
    public boolean check(String phoneNo, String code);
}
