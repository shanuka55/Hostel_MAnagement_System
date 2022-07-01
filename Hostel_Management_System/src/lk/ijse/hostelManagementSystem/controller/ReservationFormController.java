package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.hostelManagementSystem.bo.Custom.StudentBO;
import lk.ijse.hostelManagementSystem.bo.Custom.impl.StudentBOImpl;
import lk.ijse.hostelManagementSystem.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservationFormController {
    public FontAwesomeIconView homeId;
    public JFXButton backbtnId;
    public JFXButton confirmReservationBtnId;
    public JFXButton cancelReservationBtnId;
    public JFXButton checkAvailabilityId;

    public Label lblTime;
    public Label lblDate;
    public JFXTextField txtStudentId;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentAddress;
    public JFXTextField txtStudentContact;
    public RadioButton RdoStudentMale;
    public RadioButton RdoStudentFemale;
    public JFXDatePicker StudentDOB;

    public JFXTextField txtRoomId;
    public JFXTextField TxtRoomType;
    public JFXTextField txtRoomKeyMonney;
    public JFXComboBox cmbSelectRoom;

    String gender;

    StudentBO studentBO = new StudentBOImpl();

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

    public void confirmResrvationOnAction(ActionEvent actionEvent) {
        try {
            studentBO.saveStudent(new Student(txtStudentId.getText(),txtStudentName.getText(),txtStudentAddress.getText(),Integer.parseInt(txtStudentContact.getText()),String.valueOf(StudentDOB.getValue()),gender));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void StudentGenderOnAction(ActionEvent actionEvent) {
        if (RdoStudentFemale.isSelected()){
            gender = "Female";
            RdoStudentMale.setSelected(false);
        }else if (RdoStudentMale.isSelected()){
            gender = "Male";
            RdoStudentFemale.setSelected(false);

        }
    }
    public void cancelReservationOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/ReservationForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) cancelReservationBtnId.getScene().getWindow();
        stage2.close();
    }

    public void checkAvailabilityOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/ReservationTableForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) checkAvailabilityId.getScene().getWindow();
        stage2.close();

    }
}
