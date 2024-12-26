package org.telusko;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/* SERVLET
   Let us create our first Servlet. It is a good practice name the class with the Servlet suffix to identify it.
    A Servlet is a Java class used to handle HTTP requests and generate HTTP responses in a web application. It runs within a Servlet Container (like Apache Tomcat) and serves as a server-side component to extend the capabilities of web servers.
*/
public class HelloServlet extends HttpServlet {
    /* SERVICE(request, response)
        It's an important method in servlet which gets executed whenever we send a request.
    */
    public void service (HttpServletRequest req, HttpServletResponse res) {
        System.out.println("In Service");

        res.setContentType("text/html"); // The response data we are sending is html type
        PrintWriter out;

        try {
            out = res.getWriter(); // getWriter() returns a PrintWriter object that can send character text to the client.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        out.println("<h2><b>Hello World</b></h2>"); // Return a line to the client
    }
}
