package data_base;

import yaml_converter.YamlLoader;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
    private ConnectionUtil() {
    }

    private static final String DRIVER = YamlLoader.loadYamlFile("driver");
    //         "org.h2.Driver";
    private static final String URL = YamlLoader.loadYamlFile("url");
    //        "jdbc:h2:file:D:/BankProject/example/aplikaBankowaa";
//        "jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'file:tablesAndData.sql'";
    private static final String USER = YamlLoader.loadYamlFile("user");
    //        "sa";
    private static final String PASSWORD = YamlLoader.loadYamlFile("password");
//         "";

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
