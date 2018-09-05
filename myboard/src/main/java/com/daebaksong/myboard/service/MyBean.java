package com.daebaksong.myboard.service;

import com.daebaksong.ServerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyBean {
    @Value("${name}")
    private String name;

    @Autowired
    ServerInfo serverInfo;

    @PostConstruct
    public void printName(){
        System.out.println("-----------------------");
        System.out.println("name: " + name);
        System.out.println("serverInfo: " + serverInfo);
        System.out.println("-----------------------");
    }
}
