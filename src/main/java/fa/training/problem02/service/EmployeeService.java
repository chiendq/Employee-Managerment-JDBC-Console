package fa.training.problem02.service;

import fa.training.problem02.entities.Employee;

import java.sql.Date;
import java.util.List;

public interface EmployeeService<T> {
    void save(Employee employee);
    void update(Employee employee);
    Employee findById(int empNo);

    List<Employee> findByWorkTime(Date fromDate, Date toDate);
}
