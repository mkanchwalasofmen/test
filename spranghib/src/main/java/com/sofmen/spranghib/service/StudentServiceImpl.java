package com.sofmen.spranghib.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sofmen.spranghib.beans.Student;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    private static List<Student> studentList = new ArrayList<Student>();
    private static Long id = 0L;

    public List<Student> getAllStudents() {
        return studentList;
    }

    public Student getStudentById(Long id) {
        return findStudentById(id);
    }

    public void addStudent(Student student) {
        student.setId(++id);
        studentList.add(student);
    }

    public void deleteStudentById(Long id) {
        Student foundStudent = findStudentById(id);
        if (foundStudent != null) {
            studentList.remove(foundStudent);
            id--;
        }
    }

    public void deleteAll() {
        studentList.clear();
        id = 0L;
    }

    public void updateStudent(Student student) {
        Student foundStudent = findStudentById(student.getId());
        if (foundStudent != null) {
            studentList.remove(foundStudent);
            studentList.add(student);
        }
    }

    private Student findStudentById(Long id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}