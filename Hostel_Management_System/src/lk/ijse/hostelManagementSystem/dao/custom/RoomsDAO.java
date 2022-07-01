package lk.ijse.hostelManagementSystem.dao.custom;

import lk.ijse.hostelManagementSystem.dao.CrudDAO;
import lk.ijse.hostelManagementSystem.entity.Room;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RoomsDAO extends CrudDAO <Room,String> {
    ArrayList<Room> getAllRoomsById(String Id)throws ClassNotFoundException, SQLException;
}
