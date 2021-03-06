package com.application.server.http.end_point;

public interface EndPoint<Argument, Result> {
    Result invoke(Argument httpRequest) throws Exception;
}
