package com.telusko.spring_boot_rest.controller;

import com.telusko.spring_boot_rest.model.JobPost;
import com.telusko.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Conversion to Json
    We have an external library named Jackson, implemented by Spring, which automatically converts objects to Json. If we want to convert it into xml format, we need to add one more library into the pom: jackson xml.
*/

@RestController
/* @CrossOrigin
     An annotation in Spring Framework (Java) used to enable Cross-Origin Resource Sharing (CORS) for REST APIs.

     When your frontend (React, Angular, etc.) runs on a different domain (say http://localhost:3000), and your backend API is on another domain (say http://localhost:8080), the browser blocks the requests due to CORS policy. To allow this, you need to explicitly allow the frontend to access your backend API.
*/
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService jobService;

    // It will use "/jobPosts" as his path and return as a Json. We can also specify what kind of type will consume as: consumes = "application/json"
    @GetMapping(path="/jobPosts", produces = "application/json")
//    @ResponseBody // Instead of using this, we use @RestController
    public List<JobPost> findAllJobs() {
        return jobService.findAllJobs();
    }

    /* @PathVariable
        Used to extract values from the URI path and map them directly to method parameters in a controller. This is typically used in REST APIs to handle dynamic path segments.
    */
    @GetMapping("/jobPosts/{postId}")
    public JobPost getJob(@PathVariable int postId) {
        return jobService.findJobById(postId);
    }

    @PostMapping("/jobPost")
    /* @RequestBody
        If we need to send data, we use @RequestBody. On the other hand, if we want to receive data, we use @ResponseBody.
    */
    public JobPost addJob(@RequestBody JobPost jobPost) {
        jobService.addJob(jobPost);
        return jobPost;
    }

    @DeleteMapping("/jobPost/{postId}")
    public String deleteJob(@PathVariable int postId) {
        jobService.deleteJob(postId);
        return "Job Deleted";
    }

    @PutMapping("/jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        jobService.updateJob(jobPost);
        return jobService.findJobById(jobPost.getPostId());

    }
}
