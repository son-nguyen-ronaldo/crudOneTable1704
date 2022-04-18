package com.example.minitestmd4.service;

import com.example.minitestmd4.model.Student;
import com.example.minitestmd4.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    @Autowired
    StudentRepo studentRepo;
    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRepo.findAll();
    }

    @Override
    public Student findById(long id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void delete(long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentRepo.findAllByUserName(name);
    }
}
