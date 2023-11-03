package com.argo.service.impl;

import com.argo.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author YangY
 */
@Service
public class MessageServiceImpl implements MessageService {

    private HashMap<String, String> cache = new HashMap<String, String>();

    @Override
    public String get(String phoneNo) {
        String code = phoneNo.substring(phoneNo.length() - 6);
        cache.put(phoneNo, code);
        return code;
    }

    @Override
    public boolean check(String phoneNo, String code) {
        return code.equals(cache.get(phoneNo));
    }
}
