package fa.training.problem02.service.impl;

import fa.training.problem02.dao.DepartmentDAO;
import fa.training.problem02.dao.impl.DepartmentDAOImpl;
import fa.training.problem02.entities.Department;
import fa.training.problem02.service.IDepartmentService;

public class DepartmentServiceImpl implements IDepartmentService<Department> {
    @Override
    public void save(Department department) {
        DepartmentDAO departmentDAO = new DepartmentDAOImpl();
        departmentDAO.create(department);
    }
}
