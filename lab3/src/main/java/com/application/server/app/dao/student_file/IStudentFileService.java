package com.application.server.app.dao.student_file;

import com.application.commonCode.app.entity.StudentEntity;

import java.util.List;

public interface IStudentFileService {

    List<StudentEntity> getByName(String name);

    List<StudentEntity> getAll();

    void update(StudentEntity studentEntity);

    void save(StudentEntity studentEntity);

    StudentEntity getById(Integer id);
}
