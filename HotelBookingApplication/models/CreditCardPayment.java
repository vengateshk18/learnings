package HotelBookingApplication.models;

import HotelBookingApplication.constants.PaymentType;

public class CreditCardPayment implements Payment{
    private int ID;
    private static int IdCounter=100;
    private BankAccount account;

    public CreditCardPayment(BankAccount account){
        this.ID=IdCounter++;
        this.account=account;
    }

    public boolean pay(Double amount, Hotel hotel){
        if(this.account.getBalance()>amount){
            this.account.detectAmount(amount);
            hotel.getBankAccount().addAmount(amount); 
            return true;
        }
        return false;
    }

    public boolean refund(Double amount, Hotel hotel){
        if(hotel.getBankAccount().getBalance()>amount){
            hotel.getBankAccount().detectAmount(amount);
            this.account.addAmount(amount);
            return true;
        }
        return false;
    }

    public PaymentType getPaymentType(){
        return PaymentType.CREDIT_CARD;
    }
}
