package com.example;

import java.util.ArrayList;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MainController {


    @FXML
    private TextField userNameField;

    @FXML
    private ListView<String> userNameListView;

    BooleanProperty editMode = new SimpleBooleanProperty(false);

    @FXML
    void initialize() {
        ArrayList<String> userNameList = Storage.readuserNames();
        userNameListView.getItems().addAll(userNameList);

    }

    @FXML
    void onClickAddButton(ActionEvent event) {
         String userName = userNameField.getText();
        if(userName.isEmpty()) {
            return;
        }
        userNameListView.getItems().add(userName);
        userNameField.setText("");

    }

    @FXML
    void onClickDeleteButton(ActionEvent event) {
         int index = userNameListView.getSelectionModel().getSelectedIndex();
        if(index == -1) {          
            return;
        }
        userNameListView.getItems().remove(index);
    }
    

    @FXML
    void onClickModifyButton(ActionEvent event) {
         String userName = userNameField.getText();
        if(userName.isEmpty()) {
            return;
        }
        int index = userNameListView.getSelectionModel().getSelectedIndex();
        userNameListView.getItems().set(index, userName);
        userNameField.setText("");
        userNameListView.setDisable(false);
        editMode.set(false);
    }


    @FXML
    void onClickSaveButton(ActionEvent event) {
        ArrayList<String> userNameList = new ArrayList<>(userNameListView.getItems());
        Storage.writeuserNames(userNameList);
    }
    

    @FXML
    void onMouseClickList(MouseEvent event) {
        if(event.getClickCount() == 2) {
            editMode.set(true);
            String selected = userNameListView.getSelectionModel().getSelectedItem();
            userNameField.setText(selected);
            userNameListView.setDisable(true);
        }
    }

}
