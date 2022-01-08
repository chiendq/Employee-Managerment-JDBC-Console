package self.training.jdbc.service.impl;

import self.training.jdbc.dao.WorkingHistoryDAO;
import self.training.jdbc.dao.impl.WorkingHistoryDAOImpl;
import self.training.jdbc.entities.WorkingHistory;
import self.training.jdbc.service.WorkingHistorySerivce;

public class WorkingHistoryServiceImpl implements WorkingHistorySerivce<WorkingHistory> {
    @Override
    public void create(WorkingHistory workingHistory) {
        WorkingHistoryDAO workingHistoryDAO = new WorkingHistoryDAOImpl();
        workingHistoryDAO.save(workingHistory);
    }
}
