package ru.geekbrains.hibernate.dao;

import ru.geekbrains.hibernate.StartSession;
import ru.geekbrains.hibernate.data.Student;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private EntityManager manager;

    public StudentDAO() {
        manager = StartSession.getSession();
    }

    public void create(Student student){
        manager.getTransaction().begin();
        manager.persist(student);
        manager.getTransaction().commit();
    }

    public Student findById(Long id){
        manager.getTransaction().begin();
        Student student = manager.find(Student.class, id);
        manager.getTransaction().commit();
        return student;
    }

    public void removeById(Long id){
        manager.getTransaction().begin();
        Student student = findById(id);
        manager.remove(student);
        manager.getTransaction().commit();
    }

    public List<Student> findAll(){
        manager.getTransaction().begin();
        List<Student> list = manager.createNativeQuery("select * from students", Student.class).getResultList();
        manager.getTransaction().commit();
        return list;
    }
}
