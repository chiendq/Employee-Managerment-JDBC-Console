package fa.training.problem02.dao;

import fa.training.problem02.entities.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public interface EmployeeDAO<T, K> {
    Connection connection = null;
    List<T> findAll();

    List<T> findByWorkTime(Date fromDate, Date toDate);

    Employee findById(K emp_no);

    void update(T employee);

    void deleteById(int empNo);

    void save(T employee);
}
