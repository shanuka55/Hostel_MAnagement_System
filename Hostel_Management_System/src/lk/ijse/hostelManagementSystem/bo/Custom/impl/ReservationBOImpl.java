package lk.ijse.hostelManagementSystem.bo.Custom.impl;

import lk.ijse.hostelManagementSystem.bo.Custom.ReservationBO;
import lk.ijse.hostelManagementSystem.bo.Custom.RoomBO;
import lk.ijse.hostelManagementSystem.entity.Reservation;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationBOImpl implements ReservationBO {
    @Override
    public ArrayList<Reservation> getAllStudent() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean deleteReservation(String code) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean saveReservation(Reservation dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateReservation(Reservation dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean existsReservation(String code) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Reservation searchReservation(String code) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewReservationId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> searchReservationCode() throws SQLException, ClassNotFoundException {
        return null;
    }
}
