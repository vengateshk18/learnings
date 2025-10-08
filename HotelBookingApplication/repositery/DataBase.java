package HotelBookingApplication.repositery;

public class DataBase {
    private static DataBase instance;

    public final AccountRepositery accountRepositery;
    public final AdminRepositery adminRepositery;
    public final BankAccountRepositery bankAccountRepositery;
    public final BookingRepositery bookingRepositery;
    public final CityRepositery cityRepositery;
    public final CustomerRepositery customerRepositery;
    public final HotelRepositery hotelRepositery;
    public final LocationRepositery locationRepositery;
    public final PaymentRepositery paymentRepositery;
    public final RoomRepositery roomRepositery;

    private DataBase() {
        this.accountRepositery = new AccountRepositery();
        this.adminRepositery = new AdminRepositery();
        this.bankAccountRepositery = new BankAccountRepositery();
        this.bookingRepositery = new BookingRepositery();
        this.cityRepositery = new CityRepositery();
        this.customerRepositery = new CustomerRepositery();
        this.hotelRepositery = new HotelRepositery();
        this.locationRepositery = new LocationRepositery();
        this.paymentRepositery = new PaymentRepositery();
        this.roomRepositery = new RoomRepositery();
    }

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }
}
