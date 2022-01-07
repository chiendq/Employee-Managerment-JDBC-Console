package fa.training.problem02.service.impl;

import fa.training.problem02.dao.EmployeeDAO;
import fa.training.problem02.dao.impl.EmployeeDAOImpl;
import fa.training.problem02.entities.Employee;
import fa.training.problem02.service.EmployeeService;

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
    public List<Employee> findByWorkTime(Date fromDate, Date toDate) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        return  employeeDAO.findByWorkTime(fromDate, toDate);
    }
}
