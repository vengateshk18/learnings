package Bank;
import java.util.*;

import java.util.ArrayList;
import java.util.Random;


abstract class Card{
    public int cardNumber;
    public Account account;
    public int pin;
    public boolean isBlocked;

    public abstract Account getAccount();
}


class CreditCard extends Card{

   public  CreditCard(int cardNumber, Account account, int pin){
        this.cardNumber=cardNumber;
        this.account=account;
        this.pin=pin;
        this.isBlocked=false;
    }

    public Account getAccount(){
        return this.account;
    }
}

class DebitCard extends Card{


    public DebitCard(int cardNumber, Account account, int pin){
        this.cardNumber=cardNumber;
        this.account=account;
        this.pin=pin;
        this.isBlocked=false;
    }

    public Account getAccount(){
        return this.account;
    }
}

class Printer{
    public void print(Account ac){
        System.out.println(ac.account_number+" "+ac.balance);
    }
}


class Account{
    public static int account_number_counter=100;
    public int account_number;
    public String user_name;
    public String email;
    public int balance;
    public Card card;

    Account(String userName,String email,int balance){
        this.account_number=account_number_counter++;
        this.user_name=userName;
        this.email=email;
        this.balance=balance;
        this.card=null;
    }

    public int getAccountNumber(){
        return this.account_number;
    }

    public String getEmail(){
        return this.email;
    }

    public int getBalance(){
        return this.balance;
    }

    public void createCard(int cardNumber, int pin, String debitOrCredit){
        Card c;
        if (debitOrCredit.equals("Debit")){
            c=new DebitCard(cardNumber, this, pin);
        }
        else{
            c=new CreditCard(cardNumber, null, pin);

        }
        this.card=c;
    }

    public void blockCard(){
        this.card.isBlocked=true;
    }

    public void unBlockCard(){
        this.card.isBlocked=false;
    }
}

interface Payment{
    public void pay(Account ac, Integer amount, Account receiver);
}

class UPIPayment implements Payment{
    public void pay(Account ac, Integer amount, Account receiver){
        ac.balance-=amount;
        receiver.balance+=amount;
    }
}

class DebitCardPayment implements Payment{
    public void pay(Account ac, Integer amount, Account receiver){
        ac.balance-=amount;
        receiver.balance+=amount;
    }
}



class BankService{

    List<Account> accounts;
    Printer printer;

    BankService(){
        this.accounts=new ArrayList<>();
        this.printer=new Printer();
    }

    public void createCard(String email, int pin, String debitOrCredit){
        Account account=getAccount(email);
        Random random = new Random();
        int cardnumber = random.nextInt(100);
        account.createCard(cardnumber,pin,debitOrCredit);
    }

    public Account getAccount(String email){
        Account res=null;
        for(Account ac:this.accounts){
            if(ac.email.equals(email)){
                res=ac;
            }
        }
        return res;
    }

    public void printAccountInformation(String email){
        Account account=getAccount(email);
        printer.print(account);
    }

    public void makePayment(Payment payment, String sender, String receiver, Integer amount){
        Account senderAccount=getAccount(sender);
        Account receiverAccount=getAccount(receiver);

        payment.pay(senderAccount, amount, receiverAccount);
    }


    public void createAccount(String userName,String email,int balance){
        this.accounts.add(new Account(userName, email, balance));
    }
}

public class Main {
    public static void main(String[] args) {
        BankService service=new BankService();
        service.createAccount("venky","venky@gmail.com",1000);
        service.createAccount("john","j@gmail.com",1000);
        service.printAccountInformation("venky@gmail.com");
        service.makePayment(new UPIPayment(), "venky@gmail.com","j@gmail.com", 100);
        service.printAccountInformation("j@gmail.com");

    }
}
