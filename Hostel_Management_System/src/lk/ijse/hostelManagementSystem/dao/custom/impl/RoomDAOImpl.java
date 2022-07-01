package lk.ijse.hostelManagementSystem.dao.custom.impl;

import lk.ijse.hostelManagementSystem.dao.custom.RoomsDAO;
import lk.ijse.hostelManagementSystem.entity.Room;
import lk.ijse.hostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomsDAO {
    Session session;
    Transaction transaction;
    @Override
    public ArrayList<Room> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Room dto) throws SQLException, ClassNotFoundException {

            session = FactoryConfiguration.getInstance().getSessionFactory();
            transaction = session.beginTransaction();
            session.save(dto);
            transaction.commit();
            session.close();
            return true;
    }

    @Override
    public boolean update(Room dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Room search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> getIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean updateQty(int qty, String code) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<Room> getAllRoomsById(String Id) throws ClassNotFoundException, SQLException {

        session = FactoryConfiguration.getInstance().getSessionFactory();
        transaction = session.beginTransaction();
        Query student = session.createQuery("FROM Room WHERE rId = :rId");
        student.setParameter("rId", Id);
        List<Room> rooms = student.list();
        transaction.commit();
        session.close();
        return (ArrayList<Room>) rooms;
    }
}
