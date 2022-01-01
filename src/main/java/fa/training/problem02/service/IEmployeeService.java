package fa.training.problem02.service;

import fa.training.problem02.entities.Employee;

import java.sql.Date;
import java.util.List;

public interface IEmployeeService<T> {
    void save(T employee);
    void update(T employee);
    T findById(T empNo);
    List<Employee> findByWorkTime(Date fromDate, Date toDate);
}
