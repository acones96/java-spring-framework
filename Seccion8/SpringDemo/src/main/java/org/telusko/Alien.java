package org.telusko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;

/* @Component
    Help our Spring Framework to understand that Spring need to manage the objects of the class
 */
@Component
public class Alien {
    @Value("21") // Instead of hardcode the value, we can use @Value to inject it from outside the code.
    private int age;

    private int salary;

    @Autowired
    @Qualifier("laptop")
    private Computer computer;

    public Alien() {
        System.out.println("Alien Object Created");
    }

    public Alien(int age) {
        System.out.println("Constructor Called with one parameter");
        this.age = age;
    }

    public Alien(int age, Computer computer) {
        System.out.println("Constructor Called with two parameters");
        this.age = age;
        this.computer = computer;
    }

    @ConstructorProperties({"age", "salary", "computer"})
    public Alien(int age, int salary, Computer computer) {
        System.out.println("Constructor Called with three parameters");
        this.age = age;
        this.computer = computer;
        this.salary = salary;
    }


    public void code() {
        System.out.println("Coding");
        computer.compile();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
