package fa.training.problem02.dao.impl;

import fa.training.problem02.dao.EmployeeDAO;
import fa.training.problem02.entities.Employee;
import fa.training.utils.JDBCConnection;

import java.sql.*;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO<Employee, Integer> {


    @Override
    public List<Employee> findAll() {
        String SQLFindAll = "SELECT * FROM employee";

        Connection connection = JDBCConnection.getConnection();
        List<Employee> employeeList = null;
        try {
            PreparedStatement pst = connection.prepareStatement(SQLFindAll);
             employeeList = (List<Employee>) pst.getResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCConnection.closeConnection();
        return employeeList;
    }


    @Override
    public List<Employee> findByWorkTime(Date fromDate, Date toDate) {
        //eg : SELECT * FROM demo WHERE fromDate< "2000-01-02" AND toDate > "2000-01-02";
        String SQLFindByTime = "SELECT * FROM employee WHERE fromDate < ? AND toDate > ?";

        Connection connection = JDBCConnection.getConnection();
        List<Employee> employeeListByWorkTime = null;
        try {
            PreparedStatement pst = connection.prepareStatement(SQLFindByTime);
            pst.setDate(1, fromDate);
            pst.setDate(2, toDate);

            employeeListByWorkTime = (List<Employee>) pst.getResultSet();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        JDBCConnection.closeConnection();
        return employeeListByWorkTime;
    }

    @Override
    public Employee findById(Integer emp_no) {
        String SQLFindById = "SELECT * FROM employee WHERE id = ?";

        Connection connection = JDBCConnection.getConnection();
        Employee employeeById = null;
        try {
            PreparedStatement pst = connection.prepareStatement(SQLFindById);
            pst.setInt(1, emp_no);

            ResultSet resultSet = pst.executeQuery();
            if(resultSet.next()){
                employeeById.setNo(emp_no);
                employeeById.setBirthDate(resultSet.getDate("birth_date"));
                employeeById.setFirstName(resultSet.getString("first_name"));
                employeeById.setLastName(resultSet.getString("last_name"));
                employeeById.setGender(resultSet.getString("gender"));
                employeeById.setHireDate(resultSet.getDate("hire_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JDBCConnection.closeConnection();
        return employeeById;
    }

    @Override
    public void update(Employee employee) {
        int emp_no = employee.getNo();
        Date birth_date = employee.getBirthDate();
        String first_name = employee.getFirstName();
        String last_name = employee.getLastName();
        String gender = employee.getGender();
        Date hire_date = employee.getHireDate();

        String SQLUpdate = "UPDATE employee SET birth_date = ? , first_name = ? , last_name = ?, gender = ? , hire_date = ? WHERE emp_no = ?";

        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement(SQLUpdate);
            pst.setDate(2, birth_date);
            pst.setString(3, first_name);
            pst.setString(4, last_name);
            pst.setString(5, gender);
            pst.setDate(6, hire_date);
            pst.setInt(1, emp_no);

            if(pst.execute()){
                System.out.println("Update successfully.");
            }else{
                System.err.println("Update fail!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCConnection.closeConnection();
    }

    @Override
    public void delete(Employee employee) {
        int emp_no = employee.getNo();

        String SQLDelete = "DELETE FROM employee WHERE emp_no = ?";

        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement(SQLDelete);
            pst.setInt(1, emp_no);
            if(pst.execute()){
                System.out.println("Delete successfully.");
            }else{
                System.err.println("Delete fail!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCConnection.closeConnection();
    }

    @Override
    public void save(Employee employee) {
        int emp_no = employee.getNo();
        Date birth_date = employee.getBirthDate();
        String first_name = employee.getFirstName();
        String last_name = employee.getLastName();
        String gender = employee.getGender();
        Date hire_date = employee.getHireDate();

        String SQLUpdate = "INSERT INTO employee VALUES(?, ?, ?, ?, ?, ?)";

        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement(SQLUpdate);
            pst.setInt(1, emp_no);
            pst.setDate(2, birth_date);
            pst.setString(3, first_name);
            pst.setString(4, last_name);
            pst.setString(5, gender);
            pst.setDate(6, hire_date);

            if(pst.execute()){
                System.out.println("Create successfully.");
            }else{
                System.err.println("Create fail!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCConnection.closeConnection();
    }
}
