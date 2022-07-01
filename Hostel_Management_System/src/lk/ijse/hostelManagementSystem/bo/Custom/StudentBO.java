package lk.ijse.hostelManagementSystem.bo.Custom;

import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBO extends SuperBO {
    ArrayList<Student> getAllStudent() throws SQLException, ClassNotFoundException;

    ArrayList<Student> getAllStudentById(String id) throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllStudentIds() throws SQLException, ClassNotFoundException;

    boolean deleteStudent(String code) throws SQLException, ClassNotFoundException;

    boolean saveStudent(Student dto) throws SQLException, ClassNotFoundException;

    boolean updateStudent(Student dto) throws SQLException, ClassNotFoundException;

    boolean existsStudent(String code) throws SQLException, ClassNotFoundException;

    Student searchStudent(String code) throws SQLException, ClassNotFoundException;

    String generateNewStudentId() throws SQLException, ClassNotFoundException;

    ArrayList<String> searchStudentCode() throws SQLException, ClassNotFoundException;
}
