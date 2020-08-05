import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HistoryTransferDB {
    double currentAccountBalance;

    public void checkCashOnAccount(String login) {
        checkUserTransferHistory(login);
        while (rs.next()) {
            currentAccountBalance += rs.getDouble("CASH_TRANSACTION");
        }
    }

    public void showAllTrasnfer(String login) {
        checkUserTransferHistory(login);
        while (rs.next()) {
            System.out.println(rs.getString("NUMBER_OF_ACTION"));
            System.out.print(rs.getString("ACTION_TYPE"));
            System.out.print(rs.getDouble("CASH_TRANSACTION"));
            System.out.print(rs.getString("PESEL_RECIPIENT"));
            System.out.print(rs.getString("TITLE"));
        }
    }

    public void checkUserTransferHistory(String login) {
        String query = "Select * from ACCOUNT_HISTORY where login = ?";
        Connection connect = Connect.createConnect();
        try {
            PreparedStatement ps = connect.prepareStatement(query);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            rs.next();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
