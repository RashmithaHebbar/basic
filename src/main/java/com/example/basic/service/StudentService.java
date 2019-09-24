package com.example.basic.service;

import com.example.basic.doa.StudentDoa;
import com.example.basic.model.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired

    public StudentService(@Qualifier("fakeDao") StudentDoa studentDoa) {
        this.studentDoa = studentDoa;
    }

    private final StudentDoa studentDoa;

    public int persistNewStudent(UUID id, student student)
    {
        UUID uid = id == null ? UUID.randomUUID(): id;
        student.setId(uid);
        return studentDoa.insertNewStudent(uid,student);
    }

    public student getStudentBtID(UUID id)
    {
        return studentDoa.selectStudentBtID(id);
    }

    public List<student> getAllStudents()
    {
        return studentDoa.selectAllStudents();
    }

    public int updateStudentByID(UUID id, student studentUpdate)
    {
        return studentDoa.updateStudentByID(id,studentUpdate);
    }

    public int deleteStudentByID(UUID id)
    {
        return studentDoa.deleteStudentByID(id);
    }
}
