package com.javanotepad.controllers;

import com.javanotepad.events.WindowsEvent;
import com.javanotepad.service.INotepadService;
import com.javanotepad.service.SingleNotepadServiceImpl;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SingleFormController implements Initializable {

    private String tmpPath;
    private String tmpFileName;
    private boolean saved;
    private INotepadService instanceService;

    @FXML
    private TextArea txtBody;
    @FXML
    private MenuItem btnOpen;
    @FXML
    private MenuItem btnSave;
    @FXML
    private MenuItem btnClose;
    @FXML
    private MenuItem btnCut;
    @FXML
    private MenuItem btnCopy;
    @FXML
    private MenuItem btnPaste;
    @FXML
    private MenuItem btnDelete;
    @FXML
    private MenuItem btnQuit;
    @FXML
    private Label lblEncoding;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instanceService = new SingleNotepadServiceImpl(txtBody);
        saved = false;
        tmpFileName = "Empty file";
    }

    @FXML
    private void btnOpen_onAction(ActionEvent event) {
        btnClose.fire();
        Stage stage = (Stage) txtBody.getScene().getWindow();
        FileChooser fc = new FileChooser();
        fc.setTitle("Open File");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("All", "*.*")
        );
        File file = fc.showOpenDialog(stage);
        if (file != null) {
            try {
                this.saved = true;
                this.tmpPath = file.getPath();
                this.tmpFileName = file.getName();
                instanceService.openFile(file.getPath());
                stage.setTitle("java notepad - " + file.getName());
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }
    }

    @FXML
    private void btnSave_onAction(ActionEvent event) {
        Stage stage = (Stage) txtBody.getScene().getWindow();
        if (saved) {
            try {
                instanceService.saveFile(this.tmpPath, txtBody.getText());
                stage.setTitle("java notepad - " + this.tmpFileName);
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        } else {
            FileChooser fc = new FileChooser();
            fc.setTitle("Save File");
            fc.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text", "*.txt"),
                    new FileChooser.ExtensionFilter("All", "*.*")
            );

            File file = fc.showSaveDialog(stage);
            if (file != null) {
                try {
                    saved = true;
                    this.tmpPath = file.getPath();
                    this.tmpFileName = file.getName();
                    stage.setTitle("java notepad - " + file.getName());
                    instanceService.saveFile(file.getPath(), txtBody.getText());
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                }
            }
        }

    }

    @FXML
    private void btnClose_onAction(ActionEvent event) {
        Stage stage = (Stage) txtBody.getScene().getWindow();
        this.saved = false;
        this.tmpPath = "";
        this.tmpFileName = "Empty file";
        stage.setTitle("java notepad - Empty file*");
        instanceService.closeFile();
    }

    @FXML
    private void btnCut_onAction(ActionEvent event) {
        txtBody.cut();
    }

    @FXML
    private void btnCopy_onAction(ActionEvent event) {
        txtBody.copy();
    }

    @FXML
    private void btnPaste_onAction(ActionEvent event) {
        txtBody.paste();
    }

    @FXML
    private void btnDelete_onAction(ActionEvent event) {
        txtBody.deleteText(txtBody.getSelection());
    }

    @FXML
    private void btnQuit_onAction(ActionEvent event) {
        txtBody.fireEvent(new WindowsEvent(WindowsEvent.WINDOWS_EXIT));
    }

    @FXML
    private void txtBody_onKeyPressed(KeyEvent event) {
        Stage stage = (Stage) txtBody.getScene().getWindow();
        if (event.isControlDown()
                || event.isShiftDown()
                || event.isAltDown()) {
            // ...
        } else {
            stage.setTitle("java notepad - " + this.tmpFileName + "*");
        }
    }

    @FXML
    private void txtBody_onDragOver(DragEvent event) {
        if (event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    private void txtBody_onDragDropped(DragEvent event) {
        Stage stage = (Stage) txtBody.getScene().getWindow();
        List<File> files = event.getDragboard().getFiles();
        try {
            instanceService.openFile(files.get(0).getPath());
            this.tmpPath = files.get(0).getPath();
            this.tmpFileName = files.get(0).getName();
            this.saved = true;
            stage.setTitle("java notepad - " + this.tmpFileName);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
