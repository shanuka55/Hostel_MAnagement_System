package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ReservationTableFormController {
    public FontAwesomeIconView homeId;
    public JFXButton backbtnId;
    public JFXButton deleteBtnId;

    public void backToHomeOnAction(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) homeId.getScene().getWindow();
        stage2.close();
    }

    public void backBtnOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/ManageStudentForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) backbtnId.getScene().getWindow();
        stage2.close();
    }

    public void DeleteBtnOnAction(ActionEvent actionEvent) {
    }
}
