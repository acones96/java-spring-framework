package org.telusko.mapping;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class AlienMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int aid;
    @Column(name = "alien_name")
    private String name;
    private String tech;
/*    @OneToOne
    private LaptopMapping laptopMapping;*/
    /*@OneToMany(mappedBy = "alienMapping") // Laptop will be mapped in the laptop table instead of a reference table for the @ManyToOne
    private List<LaptopMapping> laptopMappings;*/
    @OneToMany(fetch = FetchType.EAGER) // Laptop will be mapped in the laptop table instead of a reference table for the @ManyToOne
    private List<LaptopMapping> laptopMappings;
    /*@ManyToMany // Used when laptop use @ManyToany
    private List<LaptopMapping> laptopMappings;*/
    @Transient // This will not be stored in DB
    private String extraData;
}
