package org.telusko.SpringBootDemo.Repository;

import org.springframework.stereotype.Repository;
import org.telusko.SpringBootDemo.Model.Laptop;

@Repository
public class LaptopRepository {
    public void save(Laptop laptop) {
        System.out.println("Saved in Database...");
    }
}
