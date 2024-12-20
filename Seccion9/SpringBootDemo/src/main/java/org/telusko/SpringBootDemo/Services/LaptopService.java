package org.telusko.SpringBootDemo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telusko.SpringBootDemo.Model.Laptop;
import org.telusko.SpringBootDemo.Repository.LaptopRepository;

/* @Service
    It is used to mark a class as a service that golds the business logic for an application. When applied to a class it tells Spring that the class is a service component, and it should be registered as a bean in the Spring application context.

    @Component and @Service behaves the same, the difference lies in their intended use, but in practice, both annotation serve similar functions in terms of creating Spring beans.
*/
@Service
public class LaptopService {
    @Autowired
    private LaptopRepository laptopRepository;
    public void addLaptop(Laptop laptop) {
        laptopRepository.save(laptop);
    }

    public boolean isGoodForProg(Laptop laptop) {
        return true;
    }
}

