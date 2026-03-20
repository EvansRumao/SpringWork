package com.SpringApp.webApp;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "index";

    }

    //servlet way of doing this
//    @RequestMapping("/add")
//    public String add(HttpServletRequest req, HttpSession session){
//
//        int num1=Integer.parseInt(req.getParameter("num1"));
//        int  num2=Integer.parseInt(req.getParameter("num2"));
//        int result=num1+num2;
//
//        session.setAttribute("result",result);
//        return "result.jsp";
//    }


//    public String add(@RequestParam ("num1") int num,int num2, HttpSession session) if u want to change variable name from num1 to num or anything else u can also use @RequestParam

        @RequestMapping("/add")
    public ModelAndView add(int num1, int num2, ModelAndView mv){


        int result=num1+num2;

        mv.addObject("result",result);
        mv.setViewName("result");
        return mv;
    }


    @RequestMapping("/addEmployee")
    public ModelAndView addEmployee(Employee Emp,ModelAndView mv){
        mv.addObject("Emp",Emp);
        mv.setViewName("result");
        return mv;
    }










}
