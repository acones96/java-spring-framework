package com.telusko.spring_boot_rest.service;

import com.telusko.spring_boot_rest.model.JobPost;
import com.telusko.spring_boot_rest.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* @Service
    Service annotation is a specialization of the @Component used to mark a class as a service component, which means it holds the business logic of the application. In essence, is used for classes that contain operations and domain rules that process data, interact with repositories, or call external services.
*/
@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public void addJob(JobPost jobPost) {
        jobRepository.addJob(jobPost);
    }

    public List<JobPost> findAllJobs() {
        return jobRepository.findAllJobs();
    }

    public JobPost findJobById(int postId) {
        return jobRepository.findJobById(postId);
    }

    public void updateJob(JobPost jobPost) {
        jobRepository.updateJob(jobPost);
    }

    public void deleteJob(int postId) {
        jobRepository.deleteJob(postId);
    }
}
