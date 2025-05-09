package org.telusko.hql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class StudentHQL {
    @Id
    @Column(name = "id")
    private int rollno;
    private String name;
    private int age;
    @OneToOne
    private LaptopHQL laptopHQL;
}
