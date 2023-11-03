package com.argo.controller;


import com.argo.domain.Book;
import com.argo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("msg")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("{phoneNo}")
    public String get(@PathVariable String phoneNo){
        return messageService.get(phoneNo);
    }

    @PostMapping
    public boolean check(String phoneNo, String code){
        return messageService.check(phoneNo, code);
    }
}
