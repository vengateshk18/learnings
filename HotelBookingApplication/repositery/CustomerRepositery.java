package HotelBookingApplication.repositery;

import HotelBookingApplication.models.Customer;
import HotelBookingApplication.models.Account;

public class CustomerRepositery extends Repositery<Integer,Customer>{

    @Override
    public void printAllObjects() {
        for(Customer ac:getAllObjects().values()){
            System.out.println(ac);
        }
    }   
    
    public Customer getCustomerByAccount(Account account){
        for(Customer customer:getAllObjects().values()){
            if(customer.getAccount()==account){
                return customer;
            }
        }
        return null;
    }
}
