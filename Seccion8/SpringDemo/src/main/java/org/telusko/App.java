package org.telusko;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.telusko.config.AppConfig;

public class App
{
    public static void main( String[] args )
    {
        // Specify the location of the configuration context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        /* CALL BEAN
            We can call a bean by specifying the class type or/and the name of the method that is configured in the configuration file or the ones that are register on the bean.
         */
        Desktop desktopA = context.getBean("desktop", Desktop.class);

        Desktop desktopB = context.getBean("desktop", Desktop.class); // Create desktop object again
        desktopB.compile();

        Alien alienA = context.getBean("alien", Alien.class);
        System.out.println(alienA.getAge());
        alienA.code();

        Alien alienB = context.getBean("alien", Alien.class);
        System.out.println(alienB.getAge());
        alienB.code();


    }
}
