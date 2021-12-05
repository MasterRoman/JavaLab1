package com.application.client.service;

import com.application.client.observable.Observable;
import com.application.commonCode.app.entity.StudentEntity;

import java.util.List;

public interface IFileService {

    Observable<List<StudentEntity>> getByName(String name);

    Observable<List<StudentEntity>> getAll();

    void update(StudentEntity studentEntity);

    void save(StudentEntity studentEntity);

    Observable<StudentEntity> getById(Integer id);
}
