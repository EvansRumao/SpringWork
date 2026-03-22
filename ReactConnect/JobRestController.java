package com.ControllerReact.Connection;

import com.ControllerReact.Connection.model.JobPost;
import com.ControllerReact.Connection.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //used for whatever u return will be treated as a body not as a view
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("JobPost/{postId}")
//    @ResponseBody
    public JobPost getJob(@PathVariable int postId){
            return service.getJob(postId);
    }

    @GetMapping("JobPosts")
//    @ResponseBody
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }


    @PostMapping("JobPost")
    public void addJob(@RequestBody JobPost post){
       service.addJob(post);
    }

    @PutMapping("JobPost")
    public void updateJob(@RequestBody JobPost post){
        service.updateJob(post);
    }

    @DeleteMapping("JobPost/{postID}")
    public String DeleteJob(@PathVariable int postID){
        service.Delete(postID);
        return "Deleted";
    }


}
