import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDataRecorderDB {
    public void sendUserDateToServer(User user) {
        String userData = "Insert into users values (?,?,?,?)";
        Connection connection = Connect.createConnect();
        try {
            PreparedStatement ps = connection.prepareStatement(userData);
            ps.setString(1, Long.toString(user.getPesel().getNumber()));
            ps.setString(2, user.getName());
            ps.setString(3, user.getSurname());
            ps.setString(4, user.getDateOfBirth());
            ps.executeUpdate();
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
    }
}
