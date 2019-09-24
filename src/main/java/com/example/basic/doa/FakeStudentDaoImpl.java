package com.example.basic.doa;

import com.example.basic.model.student;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository("fakeDao")
public class FakeStudentDaoImpl implements StudentDoa {
    private final Map<UUID,student> database;

    public FakeStudentDaoImpl() {
        database = new HashMap<>();
        UUID sid = UUID.randomUUID();
        database.put(sid,new student(sid,14,"Ravi","Prassu","Chemical"));
    }

    @Override
    public int insertNewStudent(UUID id, student student) {
        database.put(id, student);
        return 1;
    }

    @Override
    public student selectStudentBtID(UUID id) {
        return database.get(id);

    }

    @Override
    public List<student> selectAllStudents() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int updateStudentByID(UUID id, student studentUpdate) {
        database.put(id,studentUpdate);

        return 1;
    }

    @Override
    public int deleteStudentByID(UUID id) {
        database.remove(id);
        return 1;
    }
}
