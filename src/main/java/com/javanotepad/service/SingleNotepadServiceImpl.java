package com.javanotepad.service;

import javafx.scene.control.TextArea;

import java.io.IOException;

public class SingleNotepadServiceImpl implements INotepadService {

    private final INotepadIOService instanceNotepad;
    private TextArea itemTxt;

    public SingleNotepadServiceImpl() {
        instanceNotepad = new NotepadIOServiceImpl();
    }

    public SingleNotepadServiceImpl(TextArea item) {
        this();
        this.itemTxt = item;
    }

    @Override
    public void openFile(String path) throws IOException {
        String textContent = this.instanceNotepad.read(path);
        this.itemTxt.setText(textContent);
    }

    @Override
    public void saveFile(String path, String content) throws IOException {
        this.instanceNotepad.write(path, content);
    }

    @Override
    public void closeFile() {
        this.itemTxt.clear();
    }

}
