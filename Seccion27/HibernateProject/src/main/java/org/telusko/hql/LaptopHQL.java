package org.telusko.hql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class LaptopHQL {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int lid;
    private String brand;
    private String model;
    private int memory;
}
