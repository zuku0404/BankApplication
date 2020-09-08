package data_base.account_information;

import data_base.ConnectionUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountCashToDisplayDB {
    public BigDecimal getCurrentCash(int id) {
        String query = "SELECT SUM(TRANSFER_CASH) FROM TRANSFER Where id_user = ?";
        Connection connect = ConnectionUtil.createConnection();
        try {
            PreparedStatement ps = connect.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getBigDecimal("SUM(TRANSFER_CASH)");
        } catch (Exception ex) {
            ex.printStackTrace();
            return BigDecimal.ZERO; // tu trzeba obsluzyc wyjatek nie wiem zbytnio jak to zrobic !!
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
