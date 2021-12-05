package com.application.commonCode.http.entity.specification.exception.request;

import com.application.commonCode.http.entity.specification.HttpResponseCode;
import com.application.commonCode.http.entity.specification.exception.HttpException;

public abstract class HttpRequestException extends HttpException {

    public HttpRequestException(String message) {
        super(message);
    }

    public abstract HttpResponseCode responseCode();
}
