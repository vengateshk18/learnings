package HotelBookingApplication.models;

import HotelBookingApplication.constants.PaymentType;

public  interface Payment {
    public boolean pay(Double amount, Hotel hotel);
    public PaymentType getPaymentType();
    public boolean refund(Double amount,Hotel hotel);
}
