package HotelBookingApplication.models;

public class Account {
    private Integer ID;
    private static int IdCounter=100;
    private String email;
    private String password;
    private String userName;
    
    public Account(String email, String password, String name){
        this.ID=this.IdCounter++;
        this.email=email;
        this.password=password;
        this.userName=generateUserName(this.email,this.ID);
    }

    public String generateUserName(String email, int ID){
        String[] emailSplit=email.split("//@");
        String userName=emailSplit[0]+"@"+ID;
        return userName;
    }

    public Integer getId(){
        return this.ID;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public String getUsername(){
        return this.password;
    }

    public String toString(){
        return "Id: "+this.ID+" Email: "+this.email+" Password: "+this.password+" UserName: "+this.userName;
    }
}
