package fa.training.utils.validator;

import fa.training.utils.JDBCConnection;

import java.sql.*;

public class WorkingHistoryValidator {
    public static boolean isExist(int dept_no, int emp_no){
        String SQL = "SELECT * FROM working_history where dept_no = ? AND emp_no = ?";

        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1,dept_no);
            pst.setInt(2,emp_no);
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
