package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hostelManagementSystem.controller.Notification.NotificationController;
import lk.ijse.hostelManagementSystem.dao.custom.UiLoader;

import javax.swing.*;
import java.io.IOException;

public class LoginFormController implements UiLoader {
    public AnchorPane context;
    
    public JFXTextField userName;
    public JFXPasswordField password;
    
    public JFXButton cancelBtnId;
    public JFXButton loginbtnId;
    public JFXCheckBox ShowPasswordId;
    public JFXTextField txtPswd;

    NotificationController notification = new NotificationController();

    public void loginBtnOnAction(ActionEvent actionEvent) throws IOException {

        if(userName.getText().equals("s") && password.getText().equals("s")){
            loadUi("DashBoardForm");
            notification.confirmMassage("Login Successful...!","Welcome to the System");
        }else{
            password.setStyle("-fx-border-color: red");
            userName.setStyle("-fx-border-color: red");
            notification.errorMassage("Something Wrong...!","Please Check User Name Or Password again.");
        }
    }



    public void cancelBtnOnAction(ActionEvent actionEvent) {
    }

    public void showPasswordOnAction(ActionEvent actionEvent) {
        if (ShowPasswordId.isSelected()) {
            password.setVisible(false);
            txtPswd.setVisible(true);
            txtPswd.setText(password.getText());
        }else {
            txtPswd.setVisible(false);
            password.setVisible(true);
        }
    }

    @Override
    public void loadUi(String location) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) loginbtnId.getScene().getWindow();
        stage2.close();

    }
}
