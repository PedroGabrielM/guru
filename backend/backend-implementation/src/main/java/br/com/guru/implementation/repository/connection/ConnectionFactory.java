package br.com.guru.implementation.repository.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection connection = null;

    private static final String username = "postgres";

    private static final String password = "postgre";

    private static final String url = "jdbc:postgresql://localhost:5432/db_fai_lds";

    public static Connection getConnection() {

        try {
            if(connection == null) {
                Connection connection =  DriverManager.getConnection(
                        url,
                        username,
                        password);
            }

            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
