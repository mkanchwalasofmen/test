package com.sofmen.spranghib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sofmen.spranghib.beans.Student;
import com.sofmen.spranghib.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("studentslist.json")
    public @ResponseBody List<Student> getStudentList() {
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public @ResponseBody void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.PUT)
    public @ResponseBody void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

    @RequestMapping(value = "/removeStudent/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void removeStudent(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
    }

    @RequestMapping(value = "/removeAllStudents", method = RequestMethod.DELETE)
    public @ResponseBody void removeAllStudents() {
        studentService.deleteAll();
    }

    @RequestMapping("/layout")
    public String getStudentPartialPage(ModelMap modelMap) {
        return "students/layout";
    }
}