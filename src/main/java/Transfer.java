import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Transfer implements ActionListener {

    private String titleText;
    private String cash;
    private String peselRecipientText;
    private String operationType;

    public Transfer (String titleText, String cash, String peselRecipientText, String operationType ){

        this.titleText = titleText;
        this.cash = cash;
        this.peselRecipientText = peselRecipientText;
        this.operationType = operationType;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (operationType.equals("credit card") || operationType.equals("transfer")){
            checkCashOnAccount();
        }
        Connection connect = Connect.createConnect();
    }
    public boolean checkCashOnAccount(){
        if (cash>)
    }
}
