package com.javanotepad.service;

import com.javanotepad.models.INotepadIO;
import com.javanotepad.models.NotepadIO;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class SingleNotepad implements INotepad {

    private final INotepadIO instanceNotepad;
    private TextArea itemTxt;

    public SingleNotepad() {
        instanceNotepad = new NotepadIO();
    }

    public SingleNotepad(TextArea item) {
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
