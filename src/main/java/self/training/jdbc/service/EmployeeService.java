package self.training.jdbc.service;

import self.training.jdbc.entities.Employee;

import java.sql.Date;
import java.util.List;

public interface EmployeeService<T> {
    void save(Employee employee);
    void update(Employee employee);
    Employee findById(int empNo);
    List<Employee> finAll();
    List<Employee> findByWorkTime(Date fromDate, Date toDate);
    void deleteById(int empNo);
}
