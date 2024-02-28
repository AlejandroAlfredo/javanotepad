package com.javanotepad.models;

import java.io.IOException;

public interface INotepadIO {

    void write(String path, String content) throws IOException;

    String read(String path) throws IOException;
}
