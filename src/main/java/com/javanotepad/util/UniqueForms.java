package com.javanotepad.util;

import com.javanotepad.App;
import java.io.IOException;
import javafx.scene.layout.AnchorPane;

public class UniqueForms implements IForms {

    private String activeFXML;

    @Override
    public void openChild(String fxml, AnchorPane pnlbox) {
        try {
            if (activeFXML != null && activeFXML.equals(fxml)) {
                return;
            }
            activeFXML = fxml;
            AnchorPane childPane = (AnchorPane) App.loadFXML(fxml);
            AnchorPane.setTopAnchor(childPane, 0d);
            AnchorPane.setLeftAnchor(childPane, 0d);
            AnchorPane.setRightAnchor(childPane, 0d);
            AnchorPane.setBottomAnchor(childPane, 0d);
            pnlbox.getChildren().clear();
            pnlbox.getChildren().setAll(childPane);
            childPane.toFront();
        } catch (IOException err) {
            err.printStackTrace(System.out);
        }
    }

}
