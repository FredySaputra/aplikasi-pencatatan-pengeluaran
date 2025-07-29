package Util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public class ConnectionUtil {
    private static HikariDataSource dataSource;

    static{
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/pengeluaran");
        config.setUsername("root");
        config.setPassword("");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60 * 60_0000);
        config.setMaxLifetime(10 * 60 * 60_000);

        dataSource = new HikariDataSource(config);
    }

    public static HikariDataSource getDataSource(){return dataSource;}
}
