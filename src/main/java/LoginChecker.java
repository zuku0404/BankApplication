import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginChecker {
    public boolean checkLogin(String login) {
        String downloadLogs = " SELECT login from account WHERE login = ? ";
        Connection connection = Connect.createConnect();
        try {
            PreparedStatement ps = connection.prepareStatement(downloadLogs);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
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
