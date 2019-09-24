package com.example.basic.doa;

import com.example.basic.model.student;

import java.util.List;
import java.util.UUID;

public interface StudentDoa {
    int insertNewStudent(UUID id, student student);

    student selectStudentBtID(UUID id);

    List<student> selectAllStudents();

    int updateStudentByID(UUID id, student studentUpdate);

    int deleteStudentByID(UUID id);


}
