package lk.ijse.hostelManagementSystem.dao.custom.impl;

import lk.ijse.hostelManagementSystem.dao.custom.StudentDAO;
import lk.ijse.hostelManagementSystem.entity.Student;
import lk.ijse.hostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    Session session;
    Transaction transaction;
    @Override
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Student dto) throws SQLException, ClassNotFoundException {
        session = FactoryConfiguration.getInstance().getSessionFactory();
        transaction = session.beginTransaction();
        session.save(dto);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student dto) throws SQLException, ClassNotFoundException {

        session = FactoryConfiguration.getInstance().getSessionFactory();
        transaction = session.beginTransaction();
        Query query = session.createQuery("UPDATE Student SET name = :name, address= :address, contact= :contact, dob= :birth, gender= :gender WHERE Id = :id");
        query.setParameter("name", dto.getName());
        query.setParameter("address", dto.getAddress());
        query.setParameter("contact", dto.getContact());
        query.setParameter("birth", dto.getDob());
        query.setParameter("gender", dto.getGender());
        query.setParameter("id", dto.getId());
        query.executeUpdate();
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Student search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        session = FactoryConfiguration.getInstance().getSessionFactory();
        transaction = session.beginTransaction();
        Query delete = session.createQuery("DELETE FROM Student WHERE Id= :ID");
        delete.setParameter("ID", s);
        //session.delete(s);
        delete.executeUpdate();
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> getIds() throws SQLException, ClassNotFoundException {
        session = FactoryConfiguration.getInstance().getSessionFactory();
        transaction = session.beginTransaction();
        Query ids = session.createQuery("SELECT Id FROM Student");
        List<String> idList = ids.list();
        transaction.commit();
        session.close();
        return (ArrayList<String>) idList;
    }

    @Override
    public boolean updateQty(int qty, String code) throws SQLException, ClassNotFoundException {
        return false;
    }


    @Override
    public ArrayList<Student> getAllStudentById(String Id) throws ClassNotFoundException, SQLException {
        session = FactoryConfiguration.getInstance().getSessionFactory();
        transaction = session.beginTransaction();
        Query student = session.createQuery("FROM Student WHERE Id = :studentId");
        student.setParameter("studentId", Id);
        List<Student> students = student.list();
        transaction.commit();
        session.close();
        return (ArrayList<Student>) students;

    }
}
