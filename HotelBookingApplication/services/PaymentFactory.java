package HotelBookingApplication.services;

import HotelBookingApplication.constants.PaymentType;
import HotelBookingApplication.models.BankAccount;
import HotelBookingApplication.models.CreditCardPayment;
import HotelBookingApplication.models.Payment;
import HotelBookingApplication.models.UPIPayment;
import HotelBookingApplication.models.DebitCardPayment;

public class PaymentFactory {

    public static Payment createPayment(PaymentType paymentType, BankAccount account) {
        switch (paymentType) {
            case UPI:
                return new UPIPayment(account);
            case DEBIT_CARD:
                return new DebitCardPayment(account);
            case CREDIT_CARD:
                return new CreditCardPayment(account);
            default:
                throw new IllegalArgumentException("Unsupported payment type: " + paymentType);
        }
    }
}
