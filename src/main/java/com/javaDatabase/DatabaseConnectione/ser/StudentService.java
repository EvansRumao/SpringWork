package com.javaDatabase.DatabaseConnectione.ser;


import com.javaDatabase.DatabaseConnectione.Student;
import com.javaDatabase.DatabaseConnectione.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents(){

        return repo.findAll();
    }
    private StudentRepo repo;

    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public StudentRepo getRepo() {
        return repo;
    }

    public void addStudent(Student s) {

        repo.save(s);
    }
}
