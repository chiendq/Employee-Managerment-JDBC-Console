package fa.training.problem02.dao.impl;

import fa.training.problem02.dao.DepartmentDAO;
import fa.training.problem02.entities.Department;
import fa.training.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepartmentDAOImpl implements DepartmentDAO<Department, Integer> {
    @Override
    public void create(Department department) {
        String SQLCreate = "INSERT INTO department VALUES(?,?,?)";
        Connection connection = JDBCConnection.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLCreate);
            preparedStatement.setInt(1, department.getDeptNo());
            preparedStatement.setString(2, department.getDeptName());
            preparedStatement.setString( 3, department.getDescription());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCConnection.closeConnection();
        }
    }
}
