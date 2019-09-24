package com.example.basic.controller;

import com.example.basic.model.student;
import com.example.basic.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/students")
public class StudentResource {
    private final StudentService studentService;
    @Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE

    )
    public List<student> getAllStudents()
    {
        return studentService.getAllStudents();
    }
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentid}"
            )

    public student getStudentByID(@PathVariable("studentid") UUID studentid)
    {
        return studentService.getStudentBtID(studentid);
    }
    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE )
    public void insertNewStudent(@RequestBody student student)
    {
        studentService.persistNewStudent(UUID.randomUUID(),student);
    }
    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentid}"
    )
    public void updateStudentByID(@PathVariable("studentid") UUID studentid,@RequestBody student studentnew)
    {
        studentService.updateStudentByID(studentid,studentnew);
    }
    @RequestMapping(
            method = RequestMethod.DELETE,
            //consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentid}"
    )
    public void deleteStudentByID(@PathVariable("studentid") UUID studentid)
    {
        studentService.deleteStudentByID(studentid);
    }

}
