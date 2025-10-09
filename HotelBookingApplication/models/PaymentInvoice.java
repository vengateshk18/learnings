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
        this.senderName=sender.getAccount().getFullName();
        this.receiverName=receiver.getAccount().getFullName();
        this.senderAccount=sender;
        this.receiverAccount=receiver;
        this.amount=amount;
        this.date=LocalDateTime.now();
        this.type=type;
        this.status=status;

    }

    public int getId(){
        return this.ID;
    }

    public PaymentStatus getStatus(){
        return this.status;
    }

    public String toString(){
        return "Id: "+this.ID+" \n Sender Name: "+this.senderName+" \n Receiver Name: "+receiverName+" \n Sender Bank Account: "+senderAccount+" \n Receiver Bank Account: "+receiverAccount+" \n Amount: "+amount+" \n Date Time: "+date+" \n Payment Type: "+type+" \n Payment Status: "+status;
    }
}
