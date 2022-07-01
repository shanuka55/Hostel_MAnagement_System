package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManageUserFormController {
    public FontAwesomeIconView homeId;
    public JFXButton backbtnId;
    public JFXButton updateAccountBtnId;
    public JFXButton deleteAccountBtnId;

    public JFXButton btnNext;

    public JFXTextField txtCurrentUserName;
    public JFXTextField txtCurrentPassword;
    public JFXTextField txtNewUserName;
    public JFXTextField txtNewPassword;
    public JFXTextField txtConfirmPassword;

    public Label lblDate;
    public Label lblTime;

    public void initialize(){
        showDate();
        showTime();
    }

    private void showTime() {
        final Thread thread = new Thread(() -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm aa ");
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final String times = simpleDateFormat.format(new Date());
                Platform.runLater(() -> {
                    lblTime.setText(times);
                });
            }
        });
        thread.start();
    }

    private void showDate() {
        lblDate.setText(new SimpleDateFormat("EEEE, MMMM dd, yyyy").format(new Date()));
    }


    public void hometoHomeOnAction(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) homeId.getScene().getWindow();
        stage2.close();
    }

    public void backToDashboardOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/DashBoardForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) backbtnId.getScene().getWindow();
        stage2.close();
    }

    public void UpdateAccountOnAction(ActionEvent actionEvent) {
    }

    public void DeleteAccountBtnOnAction(ActionEvent actionEvent) {
    }

    public void nextBtnOnAction(ActionEvent actionEvent) {
    }
}
