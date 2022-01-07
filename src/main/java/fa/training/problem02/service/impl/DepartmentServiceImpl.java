package fa.training.problem02.service.impl;

import fa.training.problem02.dao.DepartmentDAO;
import fa.training.problem02.dao.impl.DepartmentDAOImpl;
import fa.training.problem02.entities.Department;
import fa.training.problem02.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService<Department> {
    @Override
    public void save(Department department) {
        DepartmentDAO departmentDAO = new DepartmentDAOImpl();
        departmentDAO.create(department);
    }
}
