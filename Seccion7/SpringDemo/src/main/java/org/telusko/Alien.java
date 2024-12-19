package org.telusko;

import java.beans.ConstructorProperties;

public class Alien {
    private int age;
    private int salary;
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
