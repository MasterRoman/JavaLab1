package com.application.server.app.service;

import com.application.commonCode.app.entity.StudentEntity;
import com.application.server.app.ServiceLocator;
import com.application.server.app.dao.iface.IStudentFileDao;
import com.application.server.app.dao.student_file.IStudentFileService;

import java.util.List;

public class StudentFileService implements IStudentFileService {

    private final IStudentFileDao studentFileDao = ServiceLocator.locate(IStudentFileDao.class);

    @Override
    public List<StudentEntity> getByName(String name) {
        return studentFileDao.getByName(name);
    }

    @Override
    public List<StudentEntity> getAll() {
        return studentFileDao.getAll();
    }

    @Override
    public StudentEntity getById(Integer id) {
        return studentFileDao.getById(id);
    }

    @Override
    public void update(StudentEntity studentEntity) {
        studentFileDao.update(studentEntity);
    }

    @Override
    public void save(StudentEntity studentEntity) {
        studentFileDao.save(studentEntity);
    }
}
