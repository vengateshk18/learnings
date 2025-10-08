package HotelBookingApplication.repositery;

import HotelBookingApplication.models.BankAccount;

public class BankAccountRepositery extends Repositery<Integer,BankAccount>{

    @Override
    public void printAllObjects() {
        for(BankAccount ac:getAllObjects().values()){
            System.out.println(ac);
        }
    }

    
}
