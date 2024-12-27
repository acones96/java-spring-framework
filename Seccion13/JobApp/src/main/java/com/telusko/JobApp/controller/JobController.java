package com.telusko.JobApp.controller;

import com.telusko.JobApp.model.JobPost;
import com.telusko.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping({"/", "/home"})
    public String home() {
        System.out.println("In Home");
        return "home";
    }

    @GetMapping("/addjob")
    public String addJob() {

        return "addjob";
    }

    @PostMapping("/handleForm")
    public String handleAddJobForm(JobPost jobPost) {
        jobService.addJob(jobPost);
        return "success";
    }

    @GetMapping("/viewalljobs")
    public String viewAllJobs(Model model) {
        List<JobPost> jobs = jobService.findAllJobs();
        model.addAttribute("jobPosts", jobs);
        return "viewalljobs";
    }
}
