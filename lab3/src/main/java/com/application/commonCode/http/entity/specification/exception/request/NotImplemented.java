package com.application.commonCode.http.entity.specification.exception.request;

import com.application.commonCode.http.entity.specification.HttpResponseCode;

public class NotImplemented extends HttpRequestException {

    public NotImplemented(String message) {
        super(message);
    }

    @Override
    public HttpResponseCode responseCode() {
        return HttpResponseCode.NOT_IMPLEMENTED;
    }
}
