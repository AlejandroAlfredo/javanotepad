package com.javanotepad.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class NotepadController implements Initializable {

    private final IForms instance = new UniqueForms();

    @FXML
    private AnchorPane pnlBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instance.openChild("singleform", pnlBox);
    }

}
