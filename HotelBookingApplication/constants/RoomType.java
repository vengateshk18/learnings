package HotelBookingApplication.constants;

public enum RoomType {
    STANDARD("Normal room with Single Bed"),
    PREMIUM("Special Room with Advanced Fecilities"),
    VIP("Well Suite Room with Living Arae");

    public final String description;

    RoomType(String description){
        this.description=description;
    }

    public String getDescription(){
        return description;
    }
}
