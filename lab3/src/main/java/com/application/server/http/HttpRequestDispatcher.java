package com.application.server.http;

import com.application.commonCode.http.entity.HttpRequest;
import com.application.commonCode.http.entity.HttpResponse;
import com.application.server.app.service.StudentFileService;
import com.application.server.http.end_point.EndPoint;
import com.application.server.http.end_point.scanner.HttpEndPointScanner;
import com.application.commonCode.command_line.CommandLine;
import com.application.commonCode.http.entity.specification.exception.request.NotImplemented;
import com.application.server.app.ServiceLocator;
import com.application.server.app.dao.iface.IStudentFileDao;
import com.application.server.app.dao.student_file.IStudentFileService;
import com.application.server.app.dao.student_file.StudentFileDao;
import com.application.server.app.handler.HttpRequestHandler;

import java.util.Map;

public class HttpRequestDispatcher {

    static {
        ServiceLocator.register(IStudentFileDao.class, new StudentFileDao());
        ServiceLocator.register(IStudentFileService.class, new StudentFileService());
    }

    private final Map<String, EndPoint<HttpRequest, HttpResponse>> endPoints;
    
    public HttpRequestDispatcher() {
        endPoints = HttpEndPointScanner.findIn(new HttpRequestHandler());
    }

    public HttpResponse dispatch(HttpRequest httpRequest) throws Exception {
        CommandLine.println(">>>>> Got request >>>>> \n\n" + httpRequest + "\n");
        EndPoint<HttpRequest, HttpResponse> endPoint = endPoints.get(httpRequest.getMethod() + httpRequest.getUrl());

        if(endPoint == null)
            throw new NotImplemented(httpRequest.getMethod() + " method not implemented yet.");

        HttpResponse httpResponse = endPoint.invoke(httpRequest);
        CommandLine.println("<<<<< Result response <<<<< \n\n" + httpResponse + "\n");
        return httpResponse == null ? HttpResponse.nullBody() : httpResponse;
    }
}
