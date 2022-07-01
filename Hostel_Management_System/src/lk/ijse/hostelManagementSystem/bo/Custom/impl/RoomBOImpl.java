package lk.ijse.hostelManagementSystem.bo.Custom.impl;

import lk.ijse.hostelManagementSystem.bo.Custom.RoomBO;
import lk.ijse.hostelManagementSystem.dao.custom.RoomsDAO;
import lk.ijse.hostelManagementSystem.dao.custom.impl.RoomDAOImpl;
import lk.ijse.hostelManagementSystem.entity.Room;

import java.sql.SQLException;
import java.util.ArrayList;

public class RoomBOImpl implements RoomBO {
    RoomsDAO roomsDAO = new RoomDAOImpl();

    @Override
    public ArrayList<Room> getAllRooms() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> getAllRoomIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Room> getAllRoomsByIds(String id) throws SQLException, ClassNotFoundException {
        return roomsDAO.getAllRoomsById(id);
    }

    @Override
    public boolean deleteRoom(String code) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean saveRoom(Room dto) throws SQLException, ClassNotFoundException {

        return roomsDAO.save(dto);
    }

    @Override
    public boolean updateRoom(Room dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean existsRoom(String code) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Room searchRoom(String code) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewRoomId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> searchRoomCode() throws SQLException, ClassNotFoundException {
        return null;
    }
}
