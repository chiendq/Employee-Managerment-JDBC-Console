package self.training.jdbc.dao.impl;

import self.training.jdbc.dao.WorkingHistoryDAO;
import self.training.jdbc.entities.WorkingHistory;
import self.training.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WorkingHistoryDAOImpl implements WorkingHistoryDAO<WorkingHistory, Integer> {
    @Override
    public void save(WorkingHistory workingHistory) {
        String SQLCreate = "INSERT INTO working_history VALUES(?, ?, ?, ?)";

        Connection connection = JDBCConnection.getConnection();

        int dept_no = workingHistory.getDeptNo();
        int emp_no = workingHistory.getEmpNo();
        Date from_date = workingHistory.getFromDate();
        Date to_date = workingHistory.getToDate();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLCreate);
            preparedStatement.setInt(1, dept_no);
            preparedStatement.setInt(2, emp_no);
            preparedStatement.setDate( 3, from_date);
            preparedStatement.setDate( 4, to_date);

            if(preparedStatement.executeUpdate() == 1 ){
                System.out.println("Create successfully.");
            }else{
                System.err.println("Create fail!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
