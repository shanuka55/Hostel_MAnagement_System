package lk.ijse.hostelManagementSystem.controller.Notification;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class NotificationController {
    Notifications notifications;
    Button ok;
    Button cancel;

    public void confirmMassage(String title, String text){
        notifications = Notifications.create();
        notifications.title(title);
        notifications.text(text);
        notifications.graphic(null);
        notifications.showConfirm();
        notifications.darkStyle();
        notifications.hideAfter(Duration.seconds(3));
        notifications.position(Pos.BASELINE_RIGHT);
        notifications.show();
    }

    public void errorMassage(String title, String text){
        notifications = Notifications.create();
        notifications.title(title);
        notifications.text(text);
        notifications.graphic(null);
        notifications.showWarning();
        notifications.darkStyle();
        notifications.hideAfter(Duration.seconds(3));
        notifications.position(Pos.BASELINE_RIGHT);
        notifications.show();
    }

    public void upperConfirmMessage(String title, String text){
        notifications = Notifications.create();
        notifications.title(title);
        notifications.text(text);
        notifications.graphic(null);
        notifications.showConfirm();
        notifications.darkStyle();
        notifications.hideAfter(Duration.seconds(3));
        notifications.position(Pos.TOP_RIGHT);
        notifications.show();
    }

    public void upperErrorMessage(String title, String text){
        notifications = Notifications.create();
        notifications.title(title);
        notifications.text(text);
        notifications.graphic(null);
        notifications.showConfirm();
        notifications.darkStyle();
        notifications.hideAfter(Duration.seconds(3));
        notifications.position(Pos.TOP_RIGHT);
        notifications.show();
    }

}
