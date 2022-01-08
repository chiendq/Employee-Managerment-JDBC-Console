package self.training.jdbc.service.impl;

import self.training.jdbc.dao.DepartmentDAO;
import self.training.jdbc.dao.impl.DepartmentDAOImpl;
import self.training.jdbc.entities.Department;
import self.training.jdbc.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService<Department> {
    @Override
    public void save(Department department) {
        DepartmentDAO departmentDAO = new DepartmentDAOImpl();
        departmentDAO.create(department);
    }
}
