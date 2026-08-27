package com.example.jobApp.controller;


import com.example.jobApp.model.JobPost;
import com.example.jobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class JobAppController {

    @Autowired
    JobService jobService;

    @PostMapping("JobPost")
    public String addPost(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
        return "job added succesfully";
    }

    @GetMapping("JobPosts")
    public  List<JobPost> getAllJobs(){
        return jobService.jobs();
    }

    @GetMapping("JobPost/{postId}")
    public Optional<JobPost> getJobPost(@PathVariable int postId){
        return jobService.findById(postId);
    }

    @PutMapping("JobPost")
    public String updatePost(@RequestBody JobPost jobPost){
        jobService.updatePost(jobPost);
        return "Post Updated Successfully";
    }

    @DeleteMapping("JobPost")
    public String deletePost(@RequestBody JobPost jobPost){
        jobService.deletePost(jobPost);
        return "JobPost deleted Succesfully";
    }

    @PostMapping("load")
    public void loadJobs(){
        jobService.loadJobs();
    }

    @GetMapping("search/{word}")
    public List<JobPost> searchByPostDesc(@PathVariable String word){
       return jobService.searchJobDescription(word);
    }

}
