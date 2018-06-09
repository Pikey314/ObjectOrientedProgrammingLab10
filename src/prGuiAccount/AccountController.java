package prGuiAccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountController implements ActionListener {

    private AccountView accountView;
    private Account account;

    public AccountController(AccountView accountView, Account account){
        this.accountView = accountView;
        this.account = account;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "BALANCE") {
            this.accountView.setBalance(this.account.getBalance());
        }
        else if (e.getActionCommand() == "WITHDRAW"){
            if (this.accountView.getAmount()>this.account.getBalance())
                this.accountView.printMessage("Not enough credits");
            else {
                this.account.withdraw(this.accountView.getAmount());
                this.accountView.printMessage(this.accountView.getAmount() + "EUR withdrawal done");
                this.accountView.setBalance(this.account.getBalance());
            }

        } else if (e.getActionCommand() == "DEPOSIT") {
            this.account.deposit(this.accountView.getAmount());
            this.accountView.printMessage(this.accountView.getAmount() + "EUR deposit done");
            this.accountView.setBalance(this.account.getBalance());

        }

    }
}
