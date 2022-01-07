package fa.training.utils.validator;

import fa.training.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentValidator {
    public static boolean isExist(int dept_no){
        String SQL = "SELECT * FROM department where dept_no = ?";

        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1,dept_no);
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
