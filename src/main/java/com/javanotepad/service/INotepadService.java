package com.javanotepad.service;

import java.io.IOException;

public interface INotepadService {

    void openFile(String path) throws IOException;

    void saveFile(String path, String content) throws IOException;

    void closeFile();
}
