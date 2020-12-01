package data_base;

import yaml_converter.YamlLoader;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
    private ConnectionUtil() {
    }

    private static final String DRIVER = YamlLoader.loadYamlFile("driver");
    private static final String URL = YamlLoader.loadYamlFile("url");
    private static final String USER = YamlLoader.loadYamlFile("user");
    private static final String PASSWORD = YamlLoader.loadYamlFile("password");


    public static Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
