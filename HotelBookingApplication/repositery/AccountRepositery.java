package HotelBookingApplication.repositery;

import HotelBookingApplication.models.Account;

public class AccountRepositery extends Repositery<Integer,Account>{

    @Override
    public void printAllObjects() {
        for(Account ac:getAllObjects().values()){
            System.out.println(ac);
        }
    }

    public Account findByEmail(String email) {
        for (Account ac : getAllObjects().values()) {
            if (ac.getEmail().equalsIgnoreCase(email)) {
                return ac;
            }
        }
        return null;
    }
}
