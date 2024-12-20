package org.telusko.SpringBootDemo.Model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class Desktop implements Computer{
    @Override
    public void compile() {
        System.out.println("Compiling in Desktop...");
    }
}
