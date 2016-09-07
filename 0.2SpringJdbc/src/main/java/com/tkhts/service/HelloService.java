package com.tkhts.service;

import org.springframework.stereotype.Service;


/**
 * This service simply modify the original message and return the new message
 */
@Service
public class HelloService {	
    public String sayHello(String name) {
        return "Hello " + name + "!";
    }
}
