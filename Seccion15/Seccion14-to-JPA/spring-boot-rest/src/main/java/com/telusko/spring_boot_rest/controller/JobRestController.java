package com.telusko.spring_boot_rest.controller;

import com.telusko.spring_boot_rest.model.JobPost;
import com.telusko.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService jobService;

    @GetMapping(path="/jobPosts", produces = "application/json")
    public List<JobPost> findAllJobs() {
        return jobService.findAllJobs();
    }

    @GetMapping("/jobPosts/{postId}")
    public JobPost getJob(@PathVariable int postId) {
        return jobService.findJobById(postId);
    }

    @GetMapping("/jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword) {
        return jobService.search(keyword);
    }

    @PostMapping("/jobPost")
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

    @GetMapping("/load")
    public String loadData() {
        jobService.load();
        return "Success";
    }
}
