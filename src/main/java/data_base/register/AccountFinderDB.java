package data_base.register;

import data_base.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountFinderDB {
    public boolean checkIfAccountNumberIsAvailable(String newAccount) {
        Connection connect = ConnectionUtil.createConnection();
        String checkAccount = "Select ACCOUNT_NUMBER from users where account_number = ? ";
        PreparedStatement pst = null;
        try {
            pst = connect.prepareStatement(checkAccount);
            pst.setString(1, newAccount);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
                try {
                    connect.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        return true;
    }
}
