package HotelBookingApplication.services;

import HotelBookingApplication.constants.RoomType;
import HotelBookingApplication.models.Hotel;
import HotelBookingApplication.models.Room;
import HotelBookingApplication.repositery.DataBase;

public class HotelService {
    private DataBase dataBase;

    public HotelService(DataBase dataBase){
        this.dataBase=dataBase;
    }

    public boolean addRoom(Hotel hotel , RoomType roomType, double price){
        Room newRoom=new Room(roomType,price, hotel);
        if(newRoom==null){
            return false;
        }
        hotel.addRoom(newRoom);
        this.dataBase.roomRepositery.addObject(newRoom.getId(), newRoom);
        return true;
    }

    public boolean addRoom(Hotel hotel, RoomType roomType){
        Double price=hotel.getPriceForRoomType(roomType);
        if(price==null){
            return false;
        }
        Room newRoom=new Room(roomType, price, hotel);
        hotel.addRoom(newRoom);
        this.dataBase.roomRepositery.addObject(newRoom.getId(), newRoom);
        return true;
    }

    public void changePrice(Hotel hotel, RoomType type, Double amount){
        for(Room room:this.dataBase.roomRepositery.getAllObjects().values()){
            if(room.getHotel()==hotel && room.getRoomType()==type){
                room.setPrice(amount);
            }
        }
    }

    public boolean deleteRoom(Hotel hotel, int roomId){
        Room roomObject=null;
        for(Room room:this.dataBase.roomRepositery.getAllObjects().values()){
            if(room.getHotel()==hotel && room.getId()==roomId){
                 roomObject=room;
            }
        }
        if(roomObject==null){
            return false;
        }
        this.dataBase.roomRepositery.removeIfAvailable(roomObject.getId());
        return true;
    }
}
