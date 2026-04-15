package com.Project.JobApp.service;

import com.Project.JobApp.model.JobPost;
import com.Project.JobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    public JobRepo repo;

    public void addJob(JobPost jobPost){
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return repo.findAll();
    }

    public Optional<JobPost> getJob(int postId){
        return repo.findById(postId);
    }

    public void updateJob(JobPost jobPost){
        repo.save(jobPost);
    }

    public void delete(int ID){
        repo.deleteById(ID);
    }
}