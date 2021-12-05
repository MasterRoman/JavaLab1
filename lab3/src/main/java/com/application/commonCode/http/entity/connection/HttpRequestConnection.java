package com.application.commonCode.http.entity.connection;

import com.application.commonCode.connection.Connection;
import com.application.commonCode.connection.IConnection;
import com.application.commonCode.http.entity.HttpRequest;
import com.application.commonCode.http.entity.HttpResponse;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public class HttpRequestConnection implements IConnection<HttpResponse, HttpRequest> {

    private final Connection connection;

    @Override
    public void write(byte[] writable) throws IOException {
        connection.write(writable);
    }

    @Override
    public HttpRequest readAll() throws IOException {
        return new HttpRequest(connection.readAll());
    }

    @Override
    public void write(HttpResponse writable) throws IOException {
        connection.write(writable.toString());
    }

    @Override
    public void shutdownOutput() throws IOException {
        connection.shutdownOutput();
    }

    @Override
    public void close() throws IOException {
        connection.close();
    }
}
