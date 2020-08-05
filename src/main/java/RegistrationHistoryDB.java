import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationHistoryDB implements ActionListener {

    public void addTransferToHistory(String peselUser,String actionType,String cashTransaction,
                                     String peselRecipient, String title) {

        String query = "Insert into ACCOUNT_HISTORY values (?,?,?,?,?)";
        Connection connect = Connect.createConnect();
        try {
            PreparedStatement ps = connect.prepareStatement(query);
            ps.setString(1,peselUser);
            ps.setString(3,actionType);
            ps.setString(4,cashTransaction);
            ps.setString(5,peselRecipient);
            ps.setString(6,title);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}


