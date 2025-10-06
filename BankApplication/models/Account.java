package BankApplication.models;
import java.util.*;

public class Account {
    public int accountNumber;
    public String name;
    public String email;
    public String password;
    public double balance;
    public Card card;
    public List<Transaction> transactions;

    Account(int accountNumber, String name, String email, String password, double initialBalance){
        this.accountNumber=accountNumber;
        this.name=name;
        this.email=email;
        this.password=password;
        this.balance=initialBalance;
        this.card=null;
        this.transactions=new ArrayList<>();
    }

    public int getAccountNumber(){
        return this.accountNumber;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public void addCard(Card card){
        this.card=card;
    }

    public void blockCard(){
        this.card.isBlocked=true;
    }

    public double getBalance(){
        return this.balance;
    }

    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }


