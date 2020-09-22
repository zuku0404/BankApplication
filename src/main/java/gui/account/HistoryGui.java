package gui.account;

import data_base.account_information.AccountInformationFetcher;
import model.domain.transaction.Transfer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class HistoryGui {
    private int userId;

    private List<Transfer> listOfData;
    AccountInformationFetcher userHistory = new AccountInformationFetcher();
    private List<Transfer> filteredTransfers;
    String header[] = new String[]{"user name", "user surname", "recipient name", "recipient surname ",
            " type of transfer", "cash", "transfer title"};
    DefaultTableModel dtm = new DefaultTableModel();

    public HistoryGui (int userId){
        this.userId = userId;
        this.listOfData = userHistory.getHistory(userId);
        this.filteredTransfers = listOfData;
    }

    public void createTable() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel upPanel = new JPanel();
        JPanel  downPanel = new JPanel();
        String[] transferKindChooser = {"deposit", "credit card", "transfer", "all expenses", "all transaction"};
        JComboBox kindOfTransfer = new JComboBox(transferKindChooser);
        kindOfTransfer.addActionListener(actionEvent -> {
            filterData(kindOfTransfer.getSelectedItem().toString());
        });
        JLabel kindOfTransferLabel = new JLabel(" kind of transfer");

        JTable table = new JTable() {
            public boolean isCellEditable(int data, int column) {
                return false;
            }
        };
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        table.setModel(dtm); //set model into the table object
        table.setFillsViewportHeight(true);
        showData();

        frame.getContentPane().add(panel);
        panel.add(upPanel);
        panel.add(downPanel);
        upPanel.add(kindOfTransferLabel);
        upPanel.add(kindOfTransfer);
        table.setFillsViewportHeight(true);
        scrollPane.setPreferredSize(new Dimension(800,600));
        frame.setVisible(true);
        frame.setSize(600,1000);
    }
    private void showData(){
        for (int count = 0; count < filteredTransfers.size(); count++) {
            dtm.setColumnIdentifiers(header);// add header in table model
            dtm.addRow(new Object[]{filteredTransfers.get(count).getUserName(), filteredTransfers.get(count).getUserSurname(),
                    filteredTransfers.get(count).getRecipientName(), filteredTransfers.get(count).getRecipientSurname(),
                    filteredTransfers.get(count).getTransferType(), filteredTransfers.get(count).getTransferCash(),
                    filteredTransfers.get(count).getTitle()}); // add row dynamically into the table
        }
    }
    public void filterData (String kindOfTransaction){
        filteredTransfers = filteredTransfers.stream()
                .filter(transfer -> transfer.getTransferType().equals(kindOfTransaction))
                .collect(Collectors.toList());
        showData();
    }
}
