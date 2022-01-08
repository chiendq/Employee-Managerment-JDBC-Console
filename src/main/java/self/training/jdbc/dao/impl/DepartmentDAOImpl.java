package self.training.jdbc.dao.impl;

import self.training.jdbc.dao.DepartmentDAO;
import self.training.jdbc.entities.Department;
import self.training.utils.JDBCConnection;

import java.sql.Connection;
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
            if(preparedStatement.executeUpdate() == 1){
                System.out.println("Added successfully.");
            }else {
                System.err.println("Added Fail!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCConnection.closeConnection();
        }
    }
}
