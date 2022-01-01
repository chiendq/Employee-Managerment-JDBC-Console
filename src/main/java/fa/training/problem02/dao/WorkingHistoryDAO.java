package fa.training.problem02.dao;

public interface WorkingHistoryDAO<T, K> {
    void save(T workingHistory);
}
