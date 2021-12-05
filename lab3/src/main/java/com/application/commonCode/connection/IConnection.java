package com.application.commonCode.connection;

import java.io.Closeable;
import java.io.IOException;

public interface IConnection<T, R> extends Closeable {

    void write(byte[] writable) throws IOException;

    R readAll() throws IOException;

    void write(T writable) throws IOException;

    void shutdownOutput() throws IOException;
}
