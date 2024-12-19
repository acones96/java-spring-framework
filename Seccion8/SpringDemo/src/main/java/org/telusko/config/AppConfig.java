package org.telusko.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.telusko.Alien;
import org.telusko.Computer;
import org.telusko.Desktop;
import org.telusko.Laptop;

/* @Configuration
    Is used to indicate that a class contains bean definitions. These classes market with @Configuration serves as a source of bean definitions for the Spring container.
 */
@Configuration

/* @ComponentScan
    Scan these components, if there is an @Component annotation, manage them.
 */
@ComponentScan("org.telusko")
public class AppConfig {
    /* @Bean
            Define the beans where Spring automatically will call those methods and register the returned objects as beans.

            We can specify the name, or more than one name, of the bean in the annotation, but his default `name` is the method name.
     */
    /* @SCOPE
        Define if the bean is singleton or prototype.
     */
//    @Bean
//    @Scope("prototype")
//    public Desktop desktopA() {
//        return new Desktop();
//    }

    /*
        @Autowired
            Pass the object as a parameter to the object, avoiding a null value that cause NullPointerException.

        @Qualifier
            Is used to resolve ambiguity when there are multiple beans of the same type in the Spring application context. When multiple beans of the same type exist, Spring needs to know which one to inject. By default, it will try to inject the primary bean.
     */
//    @Bean
//    public Alien alienA (@Qualifier("desktopA") @Autowired Computer computer) {
//        Alien alien = new Alien();
//        alien.setAge(21); // Set a property with age value as 21
//        alien.setComputer(computer);
//        return alien;
//    }

    /* @Primary
        Is used to mark a bean as the default choice when multiple candidates of the same type exist. When Spring has more than one bean of the same type and an injection pointer does not explicitly specify which bean to use, the bean marked with @Primary is the one that gets injected by default
     */
//    @Bean
//    @Primary
//    public Laptop laptop() {
//        return new Laptop();
//    }
}
