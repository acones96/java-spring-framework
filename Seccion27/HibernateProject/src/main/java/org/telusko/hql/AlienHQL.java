package org.telusko.hql;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class AlienHQL {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int aid;
    @Column(name = "alien_name")
    private String name;
    private String tech;
    @OneToMany(fetch = FetchType.EAGER)
    private List<LaptopHQL> laptopHQLS;
    private String extraData;
}
