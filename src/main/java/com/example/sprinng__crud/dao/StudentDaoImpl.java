package com.example.sprinng__crud.dao;

import java.util.List;

import com.example.sprinng__crud.model.Student;

import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("StudentDao")
@Transactional
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Student findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Student.class, id);
    }

    public void saveStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(student);
    }

    public void saveOrUpdate(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(student);
    }

    public void deleteStudentByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Student where code = :code")
                .setParameter("code", code)
                .executeUpdate();
    }

    public List<Student> findAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Student", Student.class).getResultList();
    }

    public Student findStudentByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        try {
            return session.createQuery("from Student where code = :code", Student.class)
                    .setParameter("code", code)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    @Override
    public void deleteStudentById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.find(Student.class, id);
        if (student != null) {
            session.delete(student);
        }
    }
    @Override
    public List<Student> findStudentsByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Student where name = :name", Student.class)
                .setParameter("name", name)
                .getResultList();
    }

}
