package com.telusko.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // Spring manage this particular object
public class Alien {

    @Autowired // Spring gets the responsibility to put the Laptop object into Alien
    Laptop laptop;

    public void code() {
        laptop.compile();
        System.out.println("Coding");
    }
}
