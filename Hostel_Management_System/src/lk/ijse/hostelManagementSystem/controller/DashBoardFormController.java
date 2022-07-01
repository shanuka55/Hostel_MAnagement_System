package lk.ijse.hostelManagementSystem.controller;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.hostelManagementSystem.dao.custom.UiLoader;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DashBoardFormController implements UiLoader {
    public ImageView newReservationBtnId;
    public ImageView studentBtnId;
    public ImageView roomBtnId;
    public ImageView userBtnId;
    public Label lbtTime;
    public Label lblDate;

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
                    lbtTime.setText(times);
                });
            }
        });
        thread.start();
    }

    private void showDate() {
        lblDate.setText(new SimpleDateFormat("EEEE, MMMM dd, yyyy").format(new Date()));
    }


    public void createReservationOnAction(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/ReservationForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) newReservationBtnId.getScene().getWindow();
        stage2.close();
    }

    public void manageStudentOnAction(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/ManageStudentForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) studentBtnId.getScene().getWindow();
        stage2.close();
    }


    public void manageRoomsOnAction(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/ManageRoomForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) roomBtnId.getScene().getWindow();
        stage2.close();
    }

    public void manageUserOnAction(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/ManageUserForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) userBtnId.getScene().getWindow();
        stage2.close();
    }

    public void backHomeOnAction(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) userBtnId.getScene().getWindow();
        stage2.close();
    }

    @Override
    public void loadUi(String location) throws IOException {

    }
}
