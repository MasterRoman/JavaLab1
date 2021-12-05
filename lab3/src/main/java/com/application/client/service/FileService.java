package com.application.client.service;

import com.application.client.observable.Observable;
import com.application.commonCode.app.entity.StudentEntity;
import com.application.commonCode.http.entity.HttpRequest;
import com.application.client.localconfig.LocalConfiguration;
import com.application.client.http.HttpClient;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class FileService implements IFileService {

    private final HttpClient http = new HttpClient(LocalConfiguration.serverUrl, LocalConfiguration.port);

    @Override
    public Observable<StudentEntity> getById(Integer id) {
        return http.send(
                HttpRequest.get().addParam("id", id + ""),
                StudentEntity.class
        );
    }

    @Override
    public Observable<List<StudentEntity>> getByName(String name) {
        return http.send(
                HttpRequest.get()
                        .url("/getByName")
                        .addParam("name", name),
                new TypeToken<List<StudentEntity>>(){}.getType()
        );
    }

    @Override
    public Observable<List<StudentEntity>> getAll() {
        return http.send(
                HttpRequest.get().url("/getAll"),
                new TypeToken<List<StudentEntity>>(){}.getType()
        );
    }

    @Override
    public void update(StudentEntity studentEntity) {
        http.send(
                HttpRequest.post().body(studentEntity)
        );
    }

    @Override
    public void save(StudentEntity studentEntity) {
        http.send(
                HttpRequest.put().body(studentEntity)
        );
    }
}
