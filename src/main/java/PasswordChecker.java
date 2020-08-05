import java.sql.*;

public class PasswordChecker {
    public boolean checkPassword(String login, String password) {
        String downloadPassword = "Select * from account where login = ? ";
        Connection connection = Connect.createConnect();
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
