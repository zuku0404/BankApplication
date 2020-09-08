package data_base.account_information;

import data_base.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountNumberToDisplayDB {
    public String showAccountNumber(int id) {
        String numberAccount = "";
        String query = "Select * from USERS where ID = ?";
        Connection connect = ConnectionUtil.createConnection();
        try {
            PreparedStatement ps = connect.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            numberAccount = rs.getString("ACCOUNT_NUMBER");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            if (connect!=null){
                try {
                    connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return numberAccount;
    }
}
