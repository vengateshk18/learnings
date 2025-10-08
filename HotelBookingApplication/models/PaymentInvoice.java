package HotelBookingApplication.models;

import java.time.LocalDateTime;

import HotelBookingApplication.constants.PaymentStatus;
import HotelBookingApplication.constants.PaymentType;

public class PaymentInvoice {
    private int ID;
    private static int IdCounter=100;
    private String senderName;
    private String receiverName;
    private BankAccount senderAccount;
    private BankAccount receiverAccount;
    private double amount;
    private LocalDateTime date;
    private PaymentType type;
    private PaymentStatus status;

    public PaymentInvoice(BankAccount sender, BankAccount receiver, double amount, PaymentType type, PaymentStatus status){
        this.ID=IdCounter++;
        this.senderName=sender.getAccount().getUsername();
        this.receiverName=sender.getAccount().getUsername();
        this.senderAccount=senderAccount;
        this.receiverAccount=receiverAccount;
        this.amount=amount;
        this.date=LocalDateTime.now();
        this.type=type;
        this.status=status;

    }

    public int getId(){
        return this.ID;
    }

    public String toString(){
        return "Id: "+this.ID+" Sender Name: "+this.senderName+" Receiver Name: "+receiverName+" Sender Account: "+senderAccount+" Receiver Account: "+receiverAccount+" Amount: "+amount+" Date Time: "+date+" Payment Type: "+type+" Payment Status: "+status;
    }
}
