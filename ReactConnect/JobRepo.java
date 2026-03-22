package com.ControllerReact.Connection.repo;

import com.ControllerReact.Connection.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {
    List<JobPost> jobs = new ArrayList<>(Arrays.asList(

            new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                    List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),


            new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
                    List.of("HTML", "CSS", "JavaScript", "React")),


            new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                    List.of("Python", "Machine Learning", "Data Analysis")),


            new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                    List.of("Networking", "Cisco", "Routing", "Switching")),


            new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                    List.of("iOS Development", "Android Development", "Mobile App"))
    ));

    // method to return all JobPosts
    public List<JobPost> getAllJobs() {
        return jobs;
    }

    // method to save a job post object into arrayList
    public void addJob(JobPost job) {
        jobs.add(job);
        System.out.println(jobs);

    }

    public JobPost getJob(int i) {

        for(JobPost job:jobs){
            if(job.getPostId()==i){
                return job;
            }
        }

        return null;
    }

    public void updateJob(JobPost post) {

        for(JobPost job :jobs){
            if(job.getPostId()==post.getPostId()){
                job.setPostProfile(post.getPostProfile());
                job.setPostDesc(post.getPostDesc());
                job.setReqExperience(post.getReqExperience());
                job.setPostTechStack(post.getPostTechStack());
            }
        }

    }

    public void Delete(int postId) {

        jobs.removeIf(job -> job.getPostId() == postId);
    }
}
