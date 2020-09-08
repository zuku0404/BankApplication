package gui.account;

import data_base.account_information.UserHistory;
import account.TransferFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class HistoryGui {
    public static void main(String[] args) {
        HistoryGui.createTable(6);
    }
    public static void createTable(int userId) {
        JFrame frame = new JFrame();
        String header[] = new String[]{"user id", "recipient user id", " type of transfer", "cash", "transfer title"};
        // add header of the table
        JTable table = new JTable();
        UserHistory userHistory = new UserHistory();
        List<TransferFrame> listOfData = userHistory.showHistory(userId); //login!!
        Object[][] data = new Object[1][5];

        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(header); // add header in table model
        table.setModel(dtm); //set model into the table object

        for (int count = 0; count < listOfData.size(); count++) {
            dtm.addRow(new Object[]{listOfData.get(count).getUserId(),listOfData.get(count).getUserRecipientId(),
                    listOfData.get(count).getTransferType(),listOfData.get(count).getTransferCash(),
                    listOfData.get(count).getTitle()}); // add row dynamically into the table
        }
        table.setFillsViewportHeight(true);
        frame.getContentPane().add(table);
        frame.setSize(700,500);
        frame.setVisible(true);
    }
}
