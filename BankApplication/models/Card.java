package BankApplication.models;

public class Card {
    public int cardNumber;
    public int pin;
    public Account account;
    public boolean isBlocked;

    public Card(int cardNumber, int pin, Account account){
        this.cardNumber=cardNumber;
        this.pin=pin;
        this.account=account;
        this.isBlocked=false;
    }

    public int getPin(){
        return this.pin;
    }

    public int getCardNumber(){
        return this.cardNumber;
    }


    public String toString(){
        return account+" "+cardNumber+" "+pin;
    }
}
