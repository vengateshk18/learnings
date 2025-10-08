package HotelBookingApplication.repositery;

import HotelBookingApplication.models.Account;
import HotelBookingApplication.models.Admin;
import HotelBookingApplication.models.Customer;

public class AdminRepositery extends Repositery<Integer,HotelBookingApplication.models.Admin>{

    @Override
    public void printAllObjects() {
        for(HotelBookingApplication.models.Admin ac:getAllObjects().values()){
            System.out.println(ac);
        }
    }

    public Admin getAdminByAccount(Account account){
        for(Admin customer:getAllObjects().values()){
            if(customer.getAccount()==account){
                return customer;
            }
        }
        return null;
    }
    
}
