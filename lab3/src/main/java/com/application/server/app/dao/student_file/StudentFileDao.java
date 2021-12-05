package com.application.server.app.dao.student_file;


import com.application.commonCode.app.entity.StudentEntity;
import com.application.server.app.dao.AbstractDao;
import com.application.server.app.dao.iface.IStudentFileDao;
import com.application.server.app.dao.query.Query;

import java.util.List;
import java.util.Objects;

public class StudentFileDao extends AbstractDao<StudentEntity> implements IStudentFileDao {

    public StudentFileDao() {
        super("students.db");
    }

    @Override
    public StudentEntity getById(Integer id) {
        List<StudentEntity> results = get(new Query<>(value -> Objects.equals(id, value.getId()), StudentEntity.class));
        return results.size() > 0 ? results.get(0) : null;
    }

    @Override
    public List<StudentEntity> getByName(String name) {
        return get(new Query<>(value -> value.getName().equals(name), StudentEntity.class));
    }

    @Override
    public List<StudentEntity> getAll() {
        return get(new Query<>(value -> true, StudentEntity.class));
    }
}
