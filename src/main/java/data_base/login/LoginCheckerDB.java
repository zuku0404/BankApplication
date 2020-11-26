package data_base.login;

import data_base.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginCheckerDB {
    public int checkLogin(String login) {
        String loginCheckerQuery = " SELECT id from users WHERE login = ? ";
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = ConnectionUtil.createConnection();
            ps = connection.prepareStatement(loginCheckerQuery);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException sqlexp) {
                sqlexp.printStackTrace();
            }
        }
        return 0;
    }
}
