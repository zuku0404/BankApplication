package data_base.account_information;

import data_base.ConnectionUtil;
import account.TransferFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserHistory {
    public List<TransferFrame> showHistory(int userId) {
        List<TransferFrame> historyUserList = new ArrayList<>();
        String query = "SELECT *  FROM transfer WHERE ID_USER = ? ORDER BY ID_TRANSFER DESC ";
        Connection connect = ConnectionUtil.createConnection();
        try {
            PreparedStatement ps = connect.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next() && historyUserList.size() < 20) {
                TransferFrame userTransfer = TransferFrame.builder()
                        .userId(rs.getInt("ID_USER"))
                        .userRecipientId(rs.getInt("ID_USER_RECIPIENT"))
                        .transferType(rs.getString("TRANSFER_TYPE"))
                        .transferCash(rs.getDouble("TRANSFER_CASH"))
                        .title(rs.getString("TITLE"))
                        .build();
                historyUserList.add(userTransfer);
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
        return historyUserList;
    }
}