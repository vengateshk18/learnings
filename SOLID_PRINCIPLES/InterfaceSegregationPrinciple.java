package SOLID_PRINCIPLES;

interface BankTransfer{
    public void transfer();
}

interface UPI{
    public void makeUPIPayment();
}

interface CreditCardPayment{
    public void makeCCPayment();
}

class GooglePay implements BankTransfer,UPI, CreditCardPayment{

    @Override
    public void makeCCPayment() {
        System.out.println("CC payment credited");
    }

    @Override
    public void makeUPIPayment() {
        System.out.println("UPI payment credited");
    }

    @Override
    public void transfer() {
        System.out.println("BANk Transefer payment credited");
    }
    
}

class PhonePay implements BankTransfer,UPI{

    @Override
    public void makeUPIPayment() {
        System.out.println("UPI payment credited");
    }

    @Override
    public void transfer() {
        System.out.println("BANk Transefer payment credited");
    }
    
}

public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        GooglePay pay1=new GooglePay();
        pay1.makeCCPayment();
        pay1.makeUPIPayment();
        pay1.transfer();

        PhonePay pay=new PhonePay();
        pay.makeUPIPayment();
        pay.transfer();
    }
}
