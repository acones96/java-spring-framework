package org.telusko;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        // IoC-Container. Create our objects
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        System.out.println();

        Alien alienA = (Alien) context.getBean("alienA"); // Returns an Object class, so we downcast it to an Alien
        alienA.setAge(21);
        System.out.println(alienA.getAge());
        alienA.code();

        Alien alienB = context.getBean("alienB", Alien.class);
        System.out.println(alienB.getAge());
        alienB.code();

        Alien alienC = context.getBean("alienC", Alien.class);
        System.out.println(alienC.getAge());
        alienC.code();

        Alien alienD = context.getBean("alienD", Alien.class);
        System.out.println(alienD.getAge());
        alienD.code();
    }
}
