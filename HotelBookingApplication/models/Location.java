package HotelBookingApplication.models;

public class Location {
    private int ID;
    private static int IdCounter;
    private City city;
    private String area;
    private int pincode;

    public Location(City city, String area, int pincode) {
        this.city = city;
        this.area = area;
        this.pincode = pincode;
        this.ID = IdCounter++;
    }

    public int getId() {
        return this.ID;
    }

    public City getCity() {
        return this.city;
    }

    public String getArea() {
        return this.area;
    }

    public int getPincode() {
        return this.pincode;
    }

    public boolean checkIfLocationMatches(String location){
        String currLocation=this.area+" "+this.city+" "+pincode;
        String currLocationInWords[]=currLocation.split(" ");
        int count=0;
        String givenLocationInWords[]=location.split(" ");
        for(String word:currLocationInWords){
            for(String gword:givenLocationInWords){
                if(word.equalsIgnoreCase(gword)){
                    count++;
                    break;
                }
            }
        }
        if((count/currLocationInWords.length)>=0.49){
            return true;
        }
        return false;
    }
}
