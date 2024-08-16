package com.javanotepad.service;

import java.io.IOException;

public interface INotepadIOService {

    void write(String path, String content) throws IOException;

    String read(String path) throws IOException;
}
