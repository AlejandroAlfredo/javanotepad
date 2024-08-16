package com.javanotepad.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class NotepadIOServiceImpl implements INotepadIOService {

    public NotepadIOServiceImpl() {

    }

    private void check(String path) throws IOException {
        File doc = new File(path);
        if (!doc.exists()) {
            throw new IOException("This file does not exist");
        } else if (!doc.isFile()) {
            throw new IOException("This is not a file");
        }
    }

    @Override
    public void write(String path, String content) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < bytes.length; i++) {
            fos.write(bytes[i]);
        }
        fos.close();
    }

    @Override
    public String read(String path) throws IOException {
        check(path);
        FileInputStream fis = new FileInputStream(path);
        String message = new String(fis.readAllBytes(), StandardCharsets.UTF_8);
        int b; // bytes
        while ((b = fis.read()) >= 0) {
            message += (char) b;
        }
        fis.close();
        return message;
    }
}
