package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
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
import lk.ijse.hostelManagementSystem.bo.Custom.StudentBO;
import lk.ijse.hostelManagementSystem.bo.Custom.impl.StudentBOImpl;
import lk.ijse.hostelManagementSystem.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ManageStudentFormController {
    public FontAwesomeIconView homeId;
    public JFXButton backbtnId;
    public JFXButton updateBtnId;
    public JFXButton deleteBtnId;
    public JFXButton checkStudentBtnId;

    public Label lblTime;
    public Label lblDate;

    public JFXComboBox cmbSelectStudentId;
    public JFXTextField txtStudentId;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentAddress;
    public JFXTextField txtStudentContact;
    public JFXTextField txtStudentDOB;

    public JFXRadioButton rdoMale;
    public JFXRadioButton rdoFemale;

    StudentBO studentBO = new StudentBOImpl();
    String gender;

    public void initialize(){
        showDate();
        showTime();

        setStudentIds();
    }

    private void setStudentIds() {
        try {

            ArrayList<String> ids = studentBO.getAllStudentIds();

            cmbSelectStudentId.getItems().addAll(ids);


            cmbSelectStudentId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                String code= (String) newValue;


                ArrayList<Student> students = null;

                try {
                    students = studentBO.getAllStudentById(code);
                    for (Student student : students) {
                        txtStudentId.setText(student.getId());
                        txtStudentName.setText(student.getName());
                        txtStudentAddress.setText(student.getAddress());
                        txtStudentContact.setText(String.valueOf(student.getContact()));
                        txtStudentDOB.setText(student.getDob());
                        if (student.getGender().equals("Male")){
                            rdoMale.setSelected(true);
                        }else if (student.getGender().equals("Female")){
                            rdoFemale.setSelected(true);
                        }
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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

    public void backToDashboardOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/DashBoardForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) homeId.getScene().getWindow();
        stage2.close();
    }

    public void UpdateStudentOnAction(ActionEvent actionEvent) {
        try {
            studentBO.updateStudent(new Student(txtStudentId.getText(),txtStudentName.getText(),txtStudentAddress.getText(),Integer.parseInt(txtStudentContact.getText()),txtStudentDOB.getText(),gender));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void DeleteBtnOnAction(ActionEvent actionEvent) {
        try {
            studentBO.deleteStudent(String.valueOf(cmbSelectStudentId.getValue()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void backToHomeOnAction(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) homeId.getScene().getWindow();
        stage2.close();
    }

    public void checkStudentOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/ReservationTableForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) checkStudentBtnId.getScene().getWindow();
        stage2.close();

    }

    public void genderOnAction(ActionEvent actionEvent) {
        if (rdoFemale.isSelected()){
            gender = "Female";
            rdoMale.setSelected(false);
        }else if (rdoMale.isSelected()){
            gender = "Male";
            rdoFemale.setSelected(false);

        }
    }
}
