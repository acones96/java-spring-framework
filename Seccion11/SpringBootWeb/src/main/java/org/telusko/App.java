package org.telusko;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App
{
    public static void main( String[] args )  {
        System.out.println( "Hello World!" );

        Tomcat tomcat = new Tomcat();
//        tomcat.setPort(8080); // Set the port number

        Context context = tomcat.addContext("", null);
        Tomcat.addServlet(context, "HelloServlet", new HelloServlet()); // Mapping in embedded Tomcat
        context.addServletMappingDecoded("/hello", "HelloServlet"); // Mapping "/hello"

        tomcat.getConnector(); // `getConnector()` handles incoming HTTP requests and connections.

        try {
            tomcat.start(); // Run Tomcat
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }

        tomcat.getServer().await(); // Keep it in Running state


    }
}
