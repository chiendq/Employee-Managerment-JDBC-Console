package self.training.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariCP {
    private static HikariDataSource dataSource = null;

    private static HikariConfig config = new HikariConfig();

    static {
        config.setJdbcUrl("jdbc:mysql://localhost:3306/JPL_TEST01");
        config.setUsername("root");
        config.setPassword("");
        config.addDataSourceProperty("cachePrepStmts", true);
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("preStmtCacheSqlLimit", "2048");
        dataSource = new HikariDataSource(config);
    }

    private HikariCP(){

    }

    public  static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
