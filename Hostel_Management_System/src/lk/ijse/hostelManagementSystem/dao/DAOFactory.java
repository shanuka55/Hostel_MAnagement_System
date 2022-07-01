package lk.ijse.hostelManagementSystem.dao;

import lk.ijse.hostelManagementSystem.dao.custom.impl.ReservationDAOImpl;
import lk.ijse.hostelManagementSystem.dao.custom.impl.RoomDAOImpl;
import lk.ijse.hostelManagementSystem.dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){
    }

    public static DAOFactory getDaoFactory(){
        if (daoFactory==null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes{
        STUDENT, ROOMS, USER, RESERVATION
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types){
            case STUDENT:
                return new StudentDAOImpl();

            case ROOMS:
                return new RoomDAOImpl();

            case RESERVATION:
                return new ReservationDAOImpl();

            default:
                return null;
        }
    }
}
