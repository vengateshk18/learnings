package HotelBookingApplication.repositery;

import HotelBookingApplication.models.PaymentInvoice;
public class PaymentRepositery extends Repositery<Integer,PaymentInvoice>{
    @Override
    public void printAllObjects(){
        for(PaymentInvoice payment:getAllObjects().values()){
            System.out.println(payment);
        }
    }
}
