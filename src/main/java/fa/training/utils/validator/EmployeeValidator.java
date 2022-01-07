package fa.training.utils.validator;

import fa.training.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeValidator {
    public static boolean isExist(int empNo){
        String SQL = "SELECT * FROM employee where emp_no = ?";

        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1,empNo);
            ResultSet resultSet = pst.executeQuery();
            if(resultSet.next() == true){
                return  true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCConnection.closeConnection();
        }
        return false;
    }

}
