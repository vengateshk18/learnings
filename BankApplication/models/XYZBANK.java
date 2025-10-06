package BankApplication.models;
import java.util.*;

public class XYZBANK {
    List<Account> accounts;

    public XYZBANK(){
        this.accounts=new ArrayList<>();
    }

    public String createAccount(int accountNumber, String name, String email, String password, double initialBalance){
        if(initialBalance>100){
            Account account=new Account(accountNumber, name, email, password, initialBalance);
            this.accounts.add(account);
            return "Account Created Successfully";
        }
        return "Initial Balance Should be grater than 100 dollars";

    }
    public void createCard(String email, int cardNumber, int pin){
        Account ac=getAccount(email);
        ac.addCard(new Card(cardNumber, pin, ac));
    }

    public boolean checkTransactionAmountWithCharge(int cardNumber,double amount, TransactionType type){
        Account account=getAccount(cardNumber);
        if(type==TransactionType.ATM_CARD){
            if(amount%5!=0){
                return false;
            }
            int chargespercent=amount>100?4:2;
            double totalvalue=amount+(amount/100)*chargespercent;
            double balance=account.balance-totalvalue;
            return balance>100;
        }
        else if(type==TransactionType.SWEEP){
            return account.balance-amount>100;
        }
        return false;
    }

    public Account getAccount(String email){
        Account res=null;
        for(Account ac:this.accounts){
            if(ac.email.equals(email)){
                res=ac;
                break;
            }
        }
        return res;
    }

    public Account getAccount(int cardNumber){
        Account res=null;
        for(Account ac:this.accounts){
            if(ac.card.getCardNumber()==cardNumber){
                res=ac;
                break;
            }
        }
        return res;
    }

    public String withdrawAmount(int cardNumber, double amount){
        if(checkTransactionAmountWithCharge(cardNumber,amount,TransactionType.ATM_CARD)){
            Account account=getAccount(cardNumber);
            int chargespercent=amount>100?4:2;
            double totalvalue=amount+(amount/100)*chargespercent;
            account.balance-=totalvalue;
            int numberOfFiveUSD=(int)amount/5;
            Transaction transaction=new Transaction(account, TransactionType.ATM_CARD, amount,(amount/100)*chargespercent);
            account.addTransaction(transaction);
            return numberOfFiveUSD+" X 5 USD withdrawing...";
        }
        return "Unable to Process the Payment. Please retry with correct details.";
    }

    public String sweepCard(int cardNumber, double amount){
        if(checkTransactionAmountWithCharge(cardNumber, amount,TransactionType.SWEEP)){
            Account account=getAccount(cardNumber);
            double cashback=(amount/100);
            account.balance+=cashback;
            Transaction transaction=new Transaction(account, TransactionType.SWEEP, amount, 0.0);
            account.addTransaction(transaction);
            return "USD: "+amount+" Sweeped In Card "+cardNumber;
        }
        return "Unable to Process the Payment. Please retry with correct details.";
    }

    public double getBalance(String email){
        Account ac=getAccount(email);
        return ac.getBalance();
    }

    public double getBalance(int cardNumber){
        Account ac=getAccount(cardNumber);
        return ac.getBalance();
    }

    public void deposit(String email, int value){
        Account ac=getAccount(email);
        ac.balance+=value;
    }
}
