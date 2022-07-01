package lk.ijse.hostelManagementSystem.bo.Custom;

import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.entity.Room;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RoomBO extends SuperBO {
    ArrayList<Room> getAllRooms() throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllRoomIds() throws SQLException, ClassNotFoundException;

    ArrayList<Room> getAllRoomsByIds(String id) throws SQLException, ClassNotFoundException;

    boolean deleteRoom(String code) throws SQLException, ClassNotFoundException;

    boolean saveRoom(Room dto) throws SQLException, ClassNotFoundException;

    boolean updateRoom(Room dto) throws SQLException, ClassNotFoundException;

    boolean existsRoom(String code) throws SQLException, ClassNotFoundException;

    Room searchRoom(String code) throws SQLException, ClassNotFoundException;

    String generateNewRoomId() throws SQLException, ClassNotFoundException;

    ArrayList<String> searchRoomCode() throws SQLException, ClassNotFoundException;

}
