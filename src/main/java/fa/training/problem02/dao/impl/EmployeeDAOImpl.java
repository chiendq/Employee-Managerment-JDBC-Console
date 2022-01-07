package fa.training.problem02.dao.impl;

import fa.training.problem02.dao.EmployeeDAO;
import fa.training.problem02.entities.Employee;
import fa.training.utils.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO<Employee, Integer> {
    @Override
    public List<Employee> findAll() {
        String SQLFindAll = "SELECT * FROM employee";
        Connection connection = JDBCConnection.getConnection();
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement pst = connection.prepareStatement(SQLFindAll);
            ResultSet resultSet = pst.executeQuery();

            while (resultSet.next()){
                Employee e = new Employee();
                e.setNo(resultSet.getInt("emp_no"));
                e.setBirthDate(resultSet.getDate("birth_date"));
                e.setFirstName(resultSet.getString("first_name"));
                e.setLastName(resultSet.getString("last_name"));
                e.setGender(resultSet.getString("gender"));
                e.setHireDate(resultSet.getDate("hire_date"));
                employeeList.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCConnection.closeConnection();
        }
        return employeeList;
    }

    @Override
    public List<Employee> findByWorkTime(Date fromDate, Date toDate) {
        Connection connection = JDBCConnection.getConnection();
        //eg : SELECT * FROM demo WHERE fromDate< "2000-01-02" AND toDate > "2000-01-02";
        String SQLFindByTime = "SELECT emp.emp_no, emp.birth_date, emp.first_name, emp.last_name, emp.gender, emp.hire_date, wh.from_date, wh.to_date FROM (working_history as wh INNER JOIN employee as emp ON wh.emp_no = emp.emp_no) where wh.from_date = ? and wh.to_date =?";
        List<Employee> employeeListByWorkTime = null;
        try {
            PreparedStatement pst = connection.prepareStatement(SQLFindByTime);
            pst.setDate(1, fromDate);
            pst.setDate(2, toDate);
            employeeListByWorkTime = (List<Employee>) pst.getResultSet();
            if(employeeListByWorkTime != null) return  employeeListByWorkTime;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCConnection.closeConnection();
        }
        return employeeListByWorkTime;
    }

    @Override
    public Employee findById(Integer emp_no) {
        String SQLFindById = "SELECT * FROM employee WHERE emp_no = ?";

        Connection connection = JDBCConnection.getConnection();
        Employee employeeById = new Employee();
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
                return employeeById;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCConnection.closeConnection();
        }
        return null;
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
            pst.setDate(1, birth_date);
            pst.setString(2, first_name);
            pst.setString(3, last_name);
            pst.setString(4, gender);
            pst.setDate(5, hire_date);
            pst.setInt(6, emp_no);

            if(pst.executeUpdate() == 1){
                System.out.println("Update successfully.");
            }else{
                System.err.println("Update fail!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCConnection.closeConnection();
        }
    }

    @Override
    public void deleteById(int empNo) {
        String SQLDelete = "DELETE FROM employee WHERE emp_no = ?";

        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement(SQLDelete);
            pst.setInt(1, empNo);
            if(pst.executeUpdate() == 1){
                System.out.println("Delete successfully.");
            }else{
                System.err.println("Delete fail!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCConnection.closeConnection();
        }
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

            if(pst.executeUpdate() ==1){
                System.out.println("Create successfully.");
            }else{
                System.err.println("Create fail!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCConnection.closeConnection();
        }
    }
}
