package com.example.sprinng__crud.service;

import com.example.sprinng__crud.model.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface StudentService {

    Student findById(int id);

    void saveStudent(Student student);

    void updateStudent(Student student);

    void deleteStudentByCode(String code);

    List<Student> findAllStudents();

    Student findStudentByCode(String code);

    boolean isStudentCodeUnique(Integer id, String code);

    void saveOrUpdate(Student student);


    void deleteStudentById(int id);
    List<Student> findStudentsByName(String name);
}
