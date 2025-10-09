package HotelBookingApplication;

import HotelBookingApplication.constants.PaymentType;
import HotelBookingApplication.constants.RoomType;
import HotelBookingApplication.models.Hotel;
import HotelBookingApplication.models.Room;
import HotelBookingApplication.repositery.DataBase;
import HotelBookingApplication.services.AdminService;
import HotelBookingApplication.services.BookingService;
import HotelBookingApplication.services.HotelService;
import HotelBookingApplication.services.SearchService;
import HotelBookingApplication.services.SessionService;

public class Main {
    public static void main(String[] args) {
        DataBase database=DataBase.getInstance();
        SessionService s=new SessionService(database);
        s.customerSignUp("venky@gmail.com", "venky", "Venky","123",1000);
        s.hotelSignUp("hotel@gmail.com", "hotel", "ABC", 100, "Chennai", "gst street", 100, 1000);
        Room room=new Room(RoomType.STANDARD, 100, database.hotelRepositery.getObject(100));
        Hotel hotel=database.hotelRepositery.getObject(100);
        hotel.addRoom(room);
        database.roomRepositery.addObject(room.getId(), room);
        SearchService search=new SearchService(database);
        System.out.println("--".repeat(100));
        System.out.println(search.searchByCityName("Chennai"));
        System.out.println("--".repeat(100));
        System.out.println(database.customerRepositery.getAllObjects());
        System.out.println("--".repeat(100));
        BookingService bookingService=new BookingService(database);
        String invoice= bookingService.bookHotelRoom(100, database.customerRepositery.getObject(100), RoomType.STANDARD, PaymentType.UPI, 2, 3);
        System.out.println(invoice);
        System.out.println("--".repeat(100));
        System.out.println(bookingService.getAllBookings(database.customerRepositery.getObject(100)));
        System.out.println("--".repeat(100));
        System.out.println(bookingService.cancelBooking(database.customerRepositery.getObject(100), 100));
        System.out.println("--".repeat(100));
        AdminService adminService=new AdminService(database);
        adminService.addCity("Banglore");
        adminService.addCity("Mumbai","Mumbai is a great City");
        System.out.println(database.cityRepositery.getAllObjects());
        System.out.println("--".repeat(100));
        HotelService hotelService=new HotelService(database);
        hotelService.addRoom(database.hotelRepositery.getObject(100), RoomType.PREMIUM,1000);
        hotelService.changePrice(hotel, RoomType.PREMIUM, 100.0);
        System.out.println(database.roomRepositery.getAllObjects());
        System.out.println(s.loginCustomer("venky@gmail.com","venky"));
        System.out.println("--".repeat(100));
        System.out.println(s.loginHotel("hotel@gmail.com", "hotel"));
    }
}
