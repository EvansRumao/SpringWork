package com.Project.JobApp;

import com.Project.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class jobController {

    @Autowired
    private JobService service;

    @GetMapping({"home","/"})
    public String home() {
        return "home";
    }

    @GetMapping("/addjob")
    public String addjob() {
        return "addjob";
    }

    @GetMapping("/viewalljobs")
    public String viewJobs(Model m) {
        List<JobPost> jobs = service.getAllJobs();
        m.addAttribute("JobPost", jobs);
        return "viewalljobs";
    }

    @PostMapping("/handleForm")
    public ModelAndView handleForm(JobPost jobPost) {
        service.addJob(jobPost);
        return new ModelAndView("success", "jobPost", jobPost);
    }
}