package com.application.server.app.dao.iface;

import com.application.commonCode.app.entity.StudentEntity;

import java.util.List;

public interface IStudentFileDao extends IDao<StudentEntity> {

    List<StudentEntity> getByName(String name);

    List<StudentEntity> getAll();

    StudentEntity getById(Integer id);
}
