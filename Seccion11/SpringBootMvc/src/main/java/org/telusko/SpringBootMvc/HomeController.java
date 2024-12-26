package org.telusko.SpringBootMvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/* @Controller
    Annotation in Spring used to define a class as a Spring MVC Controller. It marks the class as a web request handler, allowing it to handle incoming HTTP requests and return views (typically HTML or JSP pages).
*/
@Controller
public class HomeController {

    @ModelAttribute("course")
    public String courseName() {
        return "Java";
    }

    /* @RequestMapping
       Is an annotation in Spring that is used to map web requests to specific handler methods or classes. It defines the URL path and HTTP method that a controller will handle.
    */
    @RequestMapping("/")
    public String home() {
        System.out.println("Home method Called");
//        return "index";
        return "alienIndex";
    }

    // 1. "/add" Using Servlets
//    @RequestMapping("/add")
//    public String add(HttpServletRequest req, HttpSession session) {
//        // Using Servlet
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int result = num1 + num2;
//
//        /* HTTPSession
//            When we have multiple pages, we want to maintain the data between the pages.
//            We use .setAttribute("nameOfData", valueOfData)
//        */
//        session.setAttribute("result", result);
//
//        return "result";
//    }


    // 2. "/add" Using Spring Boot
//    @RequestMapping("/add")
//    public String add(@RequestParam("num1") int num, int num2, Model model) {
//        /*
//            We can identify the data by using the same name in the parameter as the same id name. Otherwise, we can use the annotation @RequestParam to identify the id name to the parameter name.
//        */
//        int result = num + num2;
//
//        /* Model
//            Model is an interface used to transfer data between controller and JSP.
//        */
//        model.addAttribute("result", result);
//
//        /* View Resolver
//         We can configure to tell where it can find the files and which kind of files by using application.properties. We can find common application properties in the following URL: https://docs.spring.io/spring-boot/appendix/application-properties/index.html
//
//         We will set in the application properties the prefix and suffix of all views.
//    */
//        return "result";
//    }


    // 3. "/add" Using ModelAndView
    @RequestMapping("/add")
    public ModelAndView add(@RequestParam("num1") int num, int num2, ModelAndView mv) {

        int result = num + num2;

        /* Model and View
            ModelAndView is a class used to combine model data and view information into a single object. It allows controllers to return both the model and the view.
        */
        mv.addObject("result", result);
        mv.setViewName("result"); // Set the view file name

        return mv;
    }

    // 1. "/addAlien For Each Parameter Value
//    @RequestMapping("/addAlien")
//    public ModelAndView addAlien(@RequestParam("aid") int aid, @RequestParam("aname") String aname, ModelAndView mv) {
//
//        Alien alienA = new Alien();
//        alienA.setAid(aid);
//        alienA.setAname(aname);
//
//        /* Model and View
//            ModelAndView is a class used to combine model data and view information into a single object. It allows controllers to return both the model and the view.
//        */
//        mv.addObject("alien", alienA);
//        mv.setViewName("alienResult"); // Set the view file name
//
//        return mv;
//    }

    // 2. "/addAlien" For an Object
    @RequestMapping("/addAlien")
    /* @ModelAttribute
        Is an optional annotation, since it does this as default, used to bind a method parameter or method return value to a name model attribute and then expose it to a web view. If we want to have a different name variable, we specified at the notation as @ModelAttribute("newName")
    */
    public String addAlien(@ModelAttribute Alien alien) {
        return "alienResult";
    }

}
