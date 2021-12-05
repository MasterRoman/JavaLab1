package com.application.server.http;

import com.application.commonCode.http.entity.HttpResponse;
import com.application.commonCode.http.entity.connection.HttpRequestConnection;
import com.application.commonCode.http.entity.specification.HttpResponseCode;
import com.application.commonCode.command_line.CommandLine;
import com.application.commonCode.http.entity.specification.exception.request.HttpRequestException;
import com.application.commonCode.connection.Connection;
import com.application.commonCode.connection.IConnectionHandler;

public class HttpConnectionHandler implements IConnectionHandler {

    private final HttpRequestDispatcher httpRequestDispatcher = new HttpRequestDispatcher();

    @Override
    public void handle(Connection connection) throws Exception {
        HttpRequestConnection httpRequestConnection = new HttpRequestConnection(connection);
        try {
            httpRequestConnection.write(
                    httpRequestDispatcher.dispatch(
                            httpRequestConnection.readAll()
                    )
            );
        } catch (HttpRequestException e) {
            httpRequestConnection.write(HttpResponse.create().code(e.responseCode()));
            CommandLine.println("Error during request.");
            CommandLine.printStackTrace(e);
        } catch (Exception e) {
            httpRequestConnection.write(HttpResponse.create().code(HttpResponseCode.INTERNAL_SERVER_ERROR));
            throw e;
        }
        httpRequestConnection.shutdownOutput();
    }
}
