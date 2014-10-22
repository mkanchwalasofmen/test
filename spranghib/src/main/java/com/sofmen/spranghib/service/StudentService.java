package com.sofmen.spranghib.service;

import java.util.List;

import com.sofmen.spranghib.beans.Student;

/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/21/12
 * Time: 12:20 AM
 */
public interface StudentService {
    public List<Student> getAllStudents();

    public Student getStudentById(Long id);

    public void addStudent(Student student);

    public void deleteStudentById(Long id);

    public void deleteAll();

    public void updateStudent(Student student);
}
