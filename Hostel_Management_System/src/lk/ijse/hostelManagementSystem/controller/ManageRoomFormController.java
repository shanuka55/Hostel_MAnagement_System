package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import lk.ijse.hostelManagementSystem.bo.Custom.RoomBO;
import lk.ijse.hostelManagementSystem.bo.Custom.impl.RoomBOImpl;
import lk.ijse.hostelManagementSystem.entity.Room;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ManageRoomFormController {
    public FontAwesomeIconView homeId;
    public JFXButton backbtnId;
    public JFXButton updateBtnId;
    public JFXButton deleteBtnId;
    public JFXButton addBtnId1;

    public Label lblTime;
    public Label lblDate;

    public JFXComboBox cmbRoomType;
    public JFXTextField txtRoomId;
    public JFXTextField txtRoomKeyMoney;
    public JFXComboBox cmbRoomId;

    RoomBO roomBO = new RoomBOImpl();

    public void initialize(){
        showDate();
        showTime();

        //setRoomId();

        String[] roomTypes= {"Non-AC(RM-1324)", "Non-AC / Food(RM-5467)", "AC(RM-7896)", "AC / Food(RM-0093)"};
        cmbRoomType.getItems().addAll(roomTypes);

        cmbRoomType.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    if (newValue.equals("Non-AC(RM-1324)")){
                        txtRoomKeyMoney.setText("3100.00");
                    }else if (newValue.equals("Non-AC / Food(RM-5467)")){
                        txtRoomKeyMoney.setText("6500.00");
                    }else if (newValue.equals("AC(RM-7896)")){
                        txtRoomKeyMoney.setText("8900.00");
                    }else if (newValue.equals("AC / Food(RM-0093)")){
                        txtRoomKeyMoney.setText("16000.00");
                    }
                });


    }

//    private void setRoomId() {
//        try {
//
//            ArrayList<String> ids = roomBO.getAllRoomIds();
//
//            cmbRoomId.getItems().addAll(ids);
//
//
//            cmbRoomId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//                String code= (String) newValue;
//
//
//                ArrayList<Room> rooms = null;
//
//                try {
//                    rooms = roomBO.getAllRoomsByIds(code);
//                    for (Room room : rooms) {
//                        txtRoomId.setText(room.getRId());
//                        cmbRoomType.setValue(room.getRoomType());
//                        txtRoomKeyMoney.setText(String.valueOf(room.getKeyMoney()));
//                    }
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
//            });
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }

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


    public void backToHomeOnAction(MouseEvent mouseEvent) throws IOException {
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

    public void UpdateRoomOnAction(ActionEvent actionEvent) {
    }

    public void DeleteRoomBtnOnAction(ActionEvent actionEvent) {
    }

    public void addRoomBtnOnAction(ActionEvent actionEvent) {
        try {
            roomBO.saveRoom(new Room(txtRoomId.getText(),String.valueOf(cmbRoomType.getValue()), BigDecimal.valueOf(Double.parseDouble(txtRoomKeyMoney.getText()))));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
