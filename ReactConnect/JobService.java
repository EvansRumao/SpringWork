package com.ControllerReact.Connection.service;

import com.ControllerReact.Connection.model.JobPost;
import com.ControllerReact.Connection.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    public JobRepo repo;

    public void addJob(JobPost jobPost){
        repo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return repo.getAllJobs();
    }

    public JobPost getJob(int i) {

        return repo.getJob(i);
    }

    public void updateJob(JobPost post) {
        repo.updateJob(post);
    }

    public void Delete(int postId) {
        repo.Delete(postId);
    }
}