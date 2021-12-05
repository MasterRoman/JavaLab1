package com.application.server.app.handler;

import com.application.commonCode.app.entity.StudentEntity;
import com.application.commonCode.http.entity.HttpRequest;
import com.application.commonCode.http.entity.HttpResponse;
import com.application.commonCode.http.entity.specification.HttpMethod;
import com.application.server.app.dao.student_file.IStudentFileService;
import com.application.server.http.end_point.RequestEndPoint;
import com.application.server.app.ServiceLocator;

public class HttpRequestHandler {

    private final IStudentFileService studentFileService = ServiceLocator.locate(IStudentFileService.class);

    @RequestEndPoint(url = "/getByName", method = HttpMethod.GET)
    public HttpResponse getByName(HttpRequest httpRequest) {
        return HttpResponse.ok().body(studentFileService.getByName(httpRequest.getUrlParams().get("name")));
    }

    @RequestEndPoint(url = "/getAll", method = HttpMethod.GET)
    public HttpResponse getAll(HttpRequest httpRequest) {
        return HttpResponse.ok().body(studentFileService.getAll());
    }

    @RequestEndPoint(url = "/", method = HttpMethod.GET)
    public HttpResponse getById(HttpRequest httpRequest) {
        return HttpResponse.ok().body(studentFileService.getById(Integer.valueOf(httpRequest.getUrlParams().get("id"))));
    }

    @RequestEndPoint(url = "/", method = HttpMethod.POST)
    public HttpResponse update(HttpRequest httpRequest) {
        studentFileService.update(httpRequest.getEntity(StudentEntity.class));
        return HttpResponse.ok();
    }

    @RequestEndPoint(url = "/", method = HttpMethod.PUT)
    public HttpResponse get(HttpRequest httpRequest) {
        studentFileService.save(httpRequest.getEntity(StudentEntity.class));
        return HttpResponse.ok();
    }
}
