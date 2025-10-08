package HotelBookingApplication;

import HotelBookingApplication.repositery.DataBase;
import HotelBookingApplication.services.SearchService;
import HotelBookingApplication.services.SessionService;

public class Main {
    public static void main(String[] args) {
        DataBase database=DataBase.getInstance();
        SessionService s=new SessionService(database);
        s.customerSignUp("venky@gamil.com", "venky", "Venky","123",1000);
        s.hotelSignUp("hotel@gmail.com", "hotel", "ABC", 100, "Chennai", "gst street", 100, 10);
        // SearchService search=new SearchService(database);
        // System.out.println(search.searchByCityName("Chennai"));
        System.out.println(database.cityRepositery.getAllObjects()+" "+database.hotelRepositery.getAllObjects());
    }
}
