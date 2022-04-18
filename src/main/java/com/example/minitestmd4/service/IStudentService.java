package com.example.minitestmd4.service;

import com.example.minitestmd4.model.Student;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IStudentService {
    public List<Student> findAll();
    public Student findById(long id);
    public void save(Student student);
    public void delete(long id);
    public List<Student> findByName(String name);
}
