package HotelBookingApplication.services;

import HotelBookingApplication.constants.PaymentStatus;
import HotelBookingApplication.models.BankAccount;
import HotelBookingApplication.models.Customer;
import HotelBookingApplication.models.Hotel;
import HotelBookingApplication.models.Payment;
import HotelBookingApplication.models.PaymentInvoice;
import HotelBookingApplication.repositery.DataBase;

public class PaymentService {
    private DataBase dataBase;

    public PaymentService(DataBase dataBase){
        this.dataBase=dataBase;
    }

    public PaymentInvoice initiatePayment(Customer customer, Hotel hotel, Payment payment,double amount){
        BankAccount customerBankAccount=customer.getBankAccount();
        BankAccount hotelBankAccount=hotel.getBankAccount();
        Payment paymentMethod=payment;
        if(payment.pay(amount, hotel)){
            PaymentInvoice invoice=new PaymentInvoice(customerBankAccount, hotelBankAccount, amount,payment.getPaymentType(),PaymentStatus.SUCCESS);
            this.dataBase.paymentRepositery.addObject(invoice.getId(), invoice);
            return invoice;
        }
        PaymentInvoice invoice=new PaymentInvoice(customerBankAccount, hotelBankAccount, amount,payment.getPaymentType(),PaymentStatus.FAILED);
        this.dataBase.paymentRepositery.addObject(invoice.getId(), invoice);
        return invoice;
    }

    public PaymentInvoice refundAmount(Customer customer, Hotel hotel, Payment payment,double amount){
        BankAccount customerBankAccount=customer.getBankAccount();
        BankAccount hotelBankAccount=hotel.getBankAccount();
        Payment paymentMethod=payment;
        if(payment.refund(amount, hotel)){
            PaymentInvoice invoice=new PaymentInvoice(hotelBankAccount, customerBankAccount, amount,payment.getPaymentType(),PaymentStatus.REFUNDED);
            this.dataBase.paymentRepositery.addObject(invoice.getId(), invoice);
            return invoice;
        }
        PaymentInvoice invoice=new PaymentInvoice(customerBankAccount, hotelBankAccount, amount,payment.getPaymentType(),PaymentStatus.FAILED);
        this.dataBase.paymentRepositery.addObject(invoice.getId(), invoice);
        return invoice;
    }
}
