package com.example.sprinng__crud.dao;

import com.example.sprinng__crud.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface StudentDao {

    Student findById(int id);

    void saveStudent(Student student);

    public void saveOrUpdate(Student student);

    void deleteStudentByCode(String ssn);

    List<Student> findAllStudents();

    Student findStudentByCode(String ssn);

    void deleteStudentById(int id);
    List<Student> findStudentsByName(String name);

}
