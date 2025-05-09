package org.telusko.hibernate;

import jakarta.persistence.*;

@Entity
@Table(name = "alien_table")
public class Alien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int aid;
    @Column(name = "alien_name")
    private String name;
    private String tech;
    private Laptop laptop;

    @Transient // This will not be stored in DB
    private String extraData;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                ", laptop=" + laptop +
                '}';
    }
}
