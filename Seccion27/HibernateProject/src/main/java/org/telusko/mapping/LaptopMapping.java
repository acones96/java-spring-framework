package org.telusko.mapping;

import jakarta.persistence.*;
import lombok.Data;
import org.telusko.hibernate.Alien;

import java.util.List;

@Data
@Entity
public class LaptopMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int lid;
    private String brand;
    private String model;
    private int memory;
/*    @ManyToOne // Used when alien use @OneToMany
    private AlienMapping alienMapping;*/
    /*@ManyToMany(mappedBy = "laptopMappings") // Used when alien use @ManyToany
    private List<AlienMapping> alienMappings;
*/


}
