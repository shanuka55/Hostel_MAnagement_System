package lk.ijse.hostelManagementSystem.bo;


import lk.ijse.hostelManagementSystem.bo.Custom.impl.ReservationBOImpl;
import lk.ijse.hostelManagementSystem.bo.Custom.impl.RoomBOImpl;
import lk.ijse.hostelManagementSystem.bo.Custom.impl.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory(){
        if (boFactory==null) {
            boFactory=new BOFactory();
        }
        return boFactory;
    }

    public enum BOTypes{
        STUDENT, ROOM, RESERVATION
    }

    public SuperBO getBO(BOTypes type){
        switch (type){
            case STUDENT:
                return new StudentBOImpl();
            case ROOM:
                return new RoomBOImpl();
            case RESERVATION:
                return new ReservationBOImpl();
            default:
                return null;
        }
    }
}
