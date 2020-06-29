package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Connector {
    private static Logger logger = LoggerFactory.getLogger(Connector.class);

    private static final String URL = "jdbc:mysql://localhost:3306/black362?serverTimezone=Europe/Rome";
    private static final String USER = "black362";
    private static final String PASSWORD = "password";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException se) {
            logger.error("Can't connect to database", se);
            throw new IllegalStateException("No database connection");
        }
    }
}
