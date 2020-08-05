import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountFinderDB {
    public boolean checkIfAccountNumberIsAvailable(String newAccount) {
        Connection connect = Connect.createConnect();
        String checkAccount = "Select ACCOUNT_NUMBER from account where account_number = ? ";
        try {
            PreparedStatement pst = connect.prepareStatement(checkAccount);
            pst.setString(1, newAccount);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
