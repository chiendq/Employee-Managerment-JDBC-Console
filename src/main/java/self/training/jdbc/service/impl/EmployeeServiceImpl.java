package self.training.jdbc.service.impl;

import self.training.jdbc.dao.EmployeeDAO;
import self.training.jdbc.dao.impl.EmployeeDAOImpl;
import self.training.jdbc.entities.Employee;
import self.training.jdbc.service.EmployeeService;

import java.sql.Date;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService<Employee> {
    @Override
    public void save(Employee employee) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeDAO.save(employee);
    }

    @Override
    public void update(Employee employee) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeDAO.update(employee);
    }

    @Override
    public Employee findById(int empNo) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        return  employeeDAO.findById(empNo);
    }

    @Override
    public List<Employee> finAll() {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        return employeeDAO.findAll();
    }

    @Override
    public List<Employee> findByWorkTime(Date fromDate, Date toDate) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        return  employeeDAO.findByWorkTime(fromDate, toDate);
    }

    @Override
    public void deleteById(int empNo) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeDAO.deleteById(empNo);
    }
}
