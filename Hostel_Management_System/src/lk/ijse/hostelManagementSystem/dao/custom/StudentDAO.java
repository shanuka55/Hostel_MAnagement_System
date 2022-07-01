package lk.ijse.hostelManagementSystem.dao.custom;

import lk.ijse.hostelManagementSystem.dao.CrudDAO;
import lk.ijse.hostelManagementSystem.dao.custom.impl.StudentDAOImpl;
import lk.ijse.hostelManagementSystem.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentDAO extends CrudDAO<Student,String> {
    ArrayList<Student> getAllStudentById (String Id)throws ClassNotFoundException, SQLException;
}
