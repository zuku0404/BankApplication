package gui.account;

import controller.HistoryController;
import model.domain.transaction.TransactionType;
import model.domain.transaction.Transfer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Objects;

public class HistoryGui {

    private final HistoryController controller = new HistoryController();
    private final int userId;

    private final String[] header = new String[]{"user name", "user surname", "recipient name", "recipient surname ",
            " type of transfer", "cash", "transfer title"};

    private final TransactionType[] transferKindChooser = TransactionType.values();

    private DefaultTableModel dtm = new DefaultTableModel();
    private JTable table = new JTable(dtm);

    public HistoryGui(int userId) {
        this.userId = userId;
    }

    public void createTable() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel upPanel = new JPanel();
        JPanel downPanel = new JPanel();

        JComboBox<TransactionType> kindOfTransfer = new JComboBox<>(transferKindChooser);
        kindOfTransfer.addActionListener(actionEvent -> {
            TransactionType transfers = (TransactionType) kindOfTransfer.getSelectedItem();
            List<Transfer> filteredTransfers = controller.getFilteredTransfers(userId, Objects.requireNonNull(transfers));
            clearData();
            showData(filteredTransfers);

        });
        JLabel kindOfTransferLabel = new JLabel(" kind of transfer");
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane.setPreferredSize(new Dimension(800, 600));

        frame.getContentPane().add(panel);
        panel.add(upPanel);
        panel.add(downPanel);
        upPanel.add(kindOfTransferLabel);
        upPanel.add(kindOfTransfer);
        downPanel.add(scrollPane);

        frame.setVisible(true);
        frame.setSize(600, 1000);
    }

    private void showData(List<Transfer> filteredTransfers) {
        for (Transfer filteredTransfer : filteredTransfers) {
            dtm.setColumnIdentifiers(header);// add header in table model
            dtm.addRow(new Object[]{filteredTransfer.getUserName(), filteredTransfer.getUserSurname(),
                    filteredTransfer.getRecipientName(), filteredTransfer.getRecipientSurname(),
                    filteredTransfer.getTransferType(), filteredTransfer.getTransferCash(),
                    filteredTransfer.getTitle()}); // add row dynamically into the table
        }
    }

    private void clearData() {
        DefaultTableModel dm = (DefaultTableModel) table.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged(); // notifies the JTable that the model has changed
    }
}