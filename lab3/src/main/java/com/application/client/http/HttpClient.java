package com.application.client.http;

import com.application.client.localconfig.LocalConfiguration;
import com.application.client.observable.Observable;
import com.application.commonCode.http.entity.HttpRequest;
import com.application.commonCode.http.entity.HttpResponse;
import com.application.commonCode.http.entity.connection.HttpResponseConnection;
import com.application.commonCode.http.entity.specification.HttpResponseCode;
import com.application.commonCode.command_line.CommandLine;
import com.application.commonCode.connection.Connection;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.Socket;

@RequiredArgsConstructor
public class HttpClient {

    private final String host;
    private final int port;

    public void send(HttpRequest request) {
        new Thread(() -> {
            try (Socket socket = new Socket(LocalConfiguration.serverUrl, LocalConfiguration.port)) {

                Connection connection = new Connection(socket);
                connection.write(request.toString());

            } catch (IOException e) {
                CommandLine.println("Request error: " + e.getMessage());
            } catch (Exception e) {
                CommandLine.printStackTrace(e);
            }
        }).start();
    }

    public <R> Observable<R> send(HttpRequest request, Type resultClass) {
        Observable<R> result = new Observable<>();
        new Thread(() -> {
            try (HttpResponseConnection connection = new HttpResponseConnection(new Connection(new Socket(host, port)))) {

                connection.write(request);
                connection.shutdownOutput();
                HttpResponse response = connection.readAll();

                if (response.getCode() != HttpResponseCode.OK.getCode())
                    result.throwError(new Exception("Response is not OK: " + response.getCode() + " " + response.getMessage()));
                else
                    result.setValue(response.getEntity(resultClass));

            } catch (Exception e) {
                CommandLine.printStackTrace(e);
            }
        }).start();
        return result;
    }
}
