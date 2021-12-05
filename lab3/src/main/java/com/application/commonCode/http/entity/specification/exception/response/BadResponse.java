package com.application.commonCode.http.entity.specification.exception.response;

import com.application.commonCode.http.entity.specification.exception.HttpException;

public class BadResponse extends HttpException {

    public BadResponse(String message) {
        super(message);
    }
}
