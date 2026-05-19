package org.example.jnote.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TitleBarController {
    private double dragOffsetX, dragOffsetY;
    @FXML
    private HBox titleBar;

    @FXML
    private Label windowTitle;

    public void setTitle(String title) {
        windowTitle.setText(title);
    }

    @FXML
    private void handleTitleBarPress(MouseEvent e) {
        dragOffsetX = e.getSceneX();
        dragOffsetY = e.getSceneY();
    }

    @FXML
    public void handleTitleBarDrag(MouseEvent e) {
        Stage stage = (Stage) titleBar.getScene().getWindow();
        stage.setX(e.getScreenX() - dragOffsetX);
        stage.setY(e.getScreenY() - dragOffsetY);
    }

    @FXML
    public void handleMinimize() {
        Stage stage = (Stage) titleBar.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public void handleMaximize() {
        Stage stage = (Stage) titleBar.getScene().getWindow();
        stage.setMaximized(!stage.isMaximized());
    }

    @FXML
    public void handleClose() {
        Stage stage = (Stage) titleBar.getScene().getWindow();
        stage.close();
    }
}
