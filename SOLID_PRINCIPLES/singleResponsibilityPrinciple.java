package SOLID_PRINCIPLES;


class Account{
    int account_number;
    int balance;

    Account(int acn){
        this.account_number=acn;
        this.balance=balance;
    }
}

class BankingService{
    public void deposit(int amount, Account acn){
        acn.balance+=amount;
    }
    public int withdraw(Account acn, int amount){
        acn.balance-=amount;
        return amount;
    }
}

class NotificationService{
    public String sendMail(){
        return "Mail sended";
    }
    public String sendSMS(){
        return "SMS Sended";
    }
}

class LoanService{
    public void takeLoan(Account acn, int amount){
        acn.balance+=amount;
    }
    public String getLoanInfo(){
        return "Loan amount starts from 2 lahks";
    }
}

public class singleResponsibilityPrinciple {
    public static void main(String[] args) {
        Account acn=new Account(10);
        BankingService bserv=new BankingService();
        bserv.deposit(10, acn);
        LoanService lserv=new LoanService();
        lserv.takeLoan(acn, 1000);
    }
}
