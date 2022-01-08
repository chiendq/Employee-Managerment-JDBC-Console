package self.training.jdbc.dao;

public interface WorkingHistoryDAO<T, K> {
    void save(T workingHistory);
}
