package lk.ijse.hostelManagementSystem.bo.Custom;

import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.entity.Reservation;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservationBO extends SuperBO {
    ArrayList<Reservation> getAllStudent() throws SQLException, ClassNotFoundException;

    boolean deleteReservation(String code) throws SQLException, ClassNotFoundException;

    boolean saveReservation(Reservation dto) throws SQLException, ClassNotFoundException;

    boolean updateReservation(Reservation dto) throws SQLException, ClassNotFoundException;

    boolean existsReservation(String code) throws SQLException, ClassNotFoundException;

    Reservation searchReservation(String code) throws SQLException, ClassNotFoundException;

    String generateNewReservationId() throws SQLException, ClassNotFoundException;

    ArrayList<String> searchReservationCode() throws SQLException, ClassNotFoundException;
}
