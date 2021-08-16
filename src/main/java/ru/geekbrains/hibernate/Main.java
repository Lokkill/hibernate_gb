package ru.geekbrains.hibernate;

import ru.geekbrains.hibernate.dao.StudentDAO;
import ru.geekbrains.hibernate.data.Student;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.create(new Student("Alex", "2"));
        Student student = studentDAO.findById(1L);
        System.out.println(student);
        studentDAO.create(new Student("Maria", "15"));
        studentDAO.findById(1L);
        showList(studentDAO);

        for (int i = 0; i < 1000; i++){
            studentDAO.create(new Student("student" + i, "mark" + i));
        }
        showList(studentDAO);
    }

    private static void showList(StudentDAO studentDAO){
        List<Student> list = studentDAO.findAll();
        list.forEach(System.out::println);

    }
}
