package data_base.login;

import model.cipher.CaesarDecipher;
import data_base.ConnectionUtil;

import java.sql.*;

public class PasswordCheckerDB {
    public boolean checkPassword(String login, String password) {
        String downloadPassword = "SELECT PASSWORD FROM ACCOUNT JOIN USERS ON Users.ID = model.account.ID WHERE Users.login = ? ";
        Connection connection = ConnectionUtil.createConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(downloadPassword);
            ps.setString(1,login);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if ((CaesarDecipher.decryptPassword(rs.getString("password"))).equals(password)){
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
// czy mozna passwordChecker i LoginChecke zrobic w jednym zapytaniu