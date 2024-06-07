package com.example.sprinng__crud.service;

import java.util.List;

import com.example.sprinng__crud.dao.StudentDao;
import com.example.sprinng__crud.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("StudentService")
@Transactional
public class StudentServiceImpl implements StudentService {

    @Qualifier("StudentDao")
    @Autowired
    private StudentDao dao;

    public Student findById(int id) {
        return dao.findById(id);
    }

    public void saveStudent(Student student) {
        dao.saveStudent(student);
    }

    public void updateStudent(Student student) {
        Student entity = dao.findById(student.getId());
        if(entity != null){
            entity.setName(student.getName());
            entity.setBirthDate(student.getBirthDate());
            entity.setNationality(student.getNationality());
            entity.setCode(student.getCode());
            //dao.saveOrUpdate(student);
        }
    }

    public void deleteStudentByCode(String ssn) {
        dao.deleteStudentByCode(ssn);
    }

    public List<Student> findAllStudents() {
        return dao.findAllStudents();
    }

    public Student findStudentByCode(String ssn) {
        return dao.findStudentByCode(ssn);
    }

    public boolean isStudentCodeUnique(Integer id, String ssn) {
        Student student = findStudentByCode(ssn);
        return (student == null || (id != null && student.getId() == id));
    }

    @Override
    public void saveOrUpdate(Student student) {
        dao.saveOrUpdate(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        dao.deleteStudentById(id);
    }

    @Override
    public List<Student> findStudentsByName(String name) {
        return dao.findStudentsByName(name);
    }
}
