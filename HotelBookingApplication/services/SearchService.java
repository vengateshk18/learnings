package HotelBookingApplication.services;

import HotelBookingApplication.repositery.DataBase;
import java.util.*;

import HotelBookingApplication.constants.RoomType;
import HotelBookingApplication.models.Hotel;
import HotelBookingApplication.models.Room;

public class SearchService {
    private final DataBase dataBase;

    public SearchService(DataBase dataBase){
        this.dataBase=dataBase; 
    }


    public List<Hotel> searchByPincode(int pincode){
        List<Hotel> hotels=new ArrayList<>();
        for(Hotel hotel:this.dataBase.hotelRepositery.getAllObjects().values()){
            if(hotel.getLocation().getPincode()==pincode){
                hotels.add(hotel);
            }
        }
        return hotels;
    }
    public List<Hotel> searchByCityName(String cityName){
        List<Hotel> hotels=new ArrayList<>();
        for(Hotel hotel:this.dataBase.hotelRepositery.getAllObjects().values()){
            if(hotel.getLocation().getCity().getCityName().equalsIgnoreCase(cityName)){
                hotels.add(hotel);
            }
        }
        return hotels;
    }
    public List<Hotel> searchByRatings(int rating){
        List<Hotel> hotels=new ArrayList<>();
        for(Hotel hotel:this.dataBase.hotelRepositery.getAllObjects().values()){
            if(hotel.getRatings()>=rating){
                hotels.add(hotel);
            }
        }
        return hotels;
    }

    public List<Hotel> searchByHotelName(String name){
        List<Hotel> hotels=new ArrayList<>();
        for(Hotel hotel:this.dataBase.hotelRepositery.getAllObjects().values()){
            if(hotel.getName().equalsIgnoreCase(name)){
                hotels.add(hotel);
            }
        }
        return hotels;
    }

    public List<Hotel> searchByHotelRoomTypeAvailable(RoomType type){
        List<Hotel> hotels=new ArrayList<>();
        for(Hotel hotel:this.dataBase.hotelRepositery.getAllObjects().values()){
            for(Room room:hotel.getAllRooms()){
                if(room.getRoomType()==type && room.getBookingStatus()==false){
                    hotels.add(hotel);
                    break;
                }
            }
        }
        return hotels;
    }
    public List<Hotel> searchByPriceRange(double minPrice, double maxPrice){
        List<Hotel> hotels=new ArrayList<>();
        for(Hotel hotel:this.dataBase.hotelRepositery.getAllObjects().values()){
            for(Room room:hotel.getAllRooms()){
                if(room.getPrice()>=minPrice && room.getPrice()<=maxPrice){
                    hotels.add(hotel);
                    break;
                }
            }
        }
        return hotels;
    }

    public List<Hotel> searchByLocation(String location){
        List<Hotel> hotels=new ArrayList<>();
        for(Hotel hotel:this.dataBase.hotelRepositery.getAllObjects().values()){
            if(hotel.getLocation().checkIfLocationMatches(location)){
                hotels.add(hotel);
            }
        }
        return hotels;
    }
}

