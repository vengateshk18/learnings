package BankApplication.models;

public class Transaction {
    public TransactionType mode;
    public double amount;
    public double charges;
    public Account account;

    public Transaction(Account account, TransactionType type, double amount, double charges){
        this.account=account;
        this.mode=type;
        this.amount=amount;
        this.charges=charges;
    }

    public String toString(){
        return account+" Transaction Type: "+mode.name()+" "+" Amount: "+amount+" Charges: "+charges;
    }

}
