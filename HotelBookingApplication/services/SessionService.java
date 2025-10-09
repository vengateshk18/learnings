package HotelBookingApplication.services;

import HotelBookingApplication.models.Account;
import HotelBookingApplication.models.Admin;
import HotelBookingApplication.models.BankAccount;
import HotelBookingApplication.models.City;
import HotelBookingApplication.models.Customer;
import HotelBookingApplication.models.Hotel;
import HotelBookingApplication.models.Location;
import HotelBookingApplication.repositery.DataBase;

public class SessionService {
    public DataBase dataBase;

    public SessionService(DataBase dataBase){
        this.dataBase=dataBase;
    }

    public String encrypt(String data){
        try{
            String res="";
            for(int value:data.toCharArray()){
                res+=(char) (value+1);
            }
            return res;
        }
        catch(Exception e){ System.out.println(e.getMessage());return null;}
    }

    public String decrypt(String data){
        try{
            String res="";
            for(int value:data.toCharArray()){
                res+=(char) (value-1);
            }
            return res;
        }
        catch(Exception e){ System.out.println(e.getMessage());return null;}
    }

    public void customerSignUp(String email, String password, String name, String aadhar,double balace){
        try{
            password=encrypt(password);
            Account account=new Account(email, password, name);
            BankAccount bAccount=new BankAccount(account, balace);
            Customer customerObject=new Customer(account,aadhar,bAccount);
            this.dataBase.accountRepositery.addObject(account.getId(), account);
            this.dataBase.customerRepositery.addObject(customerObject.getId(), customerObject);
            this.dataBase.bankAccountRepositery.addObject(bAccount.getId(),bAccount);
        }
        catch(Exception e){ System.out.println(e.getMessage());}
    }

    public void adminSignUp(String email, String password,String name){
        try{
            password=encrypt(password);
            Account account=new Account(email, password, name);
            Admin admin=new Admin(account);
            this.dataBase.accountRepositery.addObject(account.getId(), account);
            this.dataBase.adminRepositery.addObject(admin.getId(), admin);
        }
        catch(Exception e){ System.out.println(e.getMessage());}
    }

    public void hotelSignUp(String email, String password, String name, int GSTNumber, String cityName, String area, int pincode, double balace){
        try{
            password=encrypt(password);
            Account account=new Account(email, password, name);
            City city=this.dataBase.cityRepositery.searchCityByName(cityName);
            if(city==null){
                city=new City(cityName);
            }
            Location location=new Location(city, area, pincode);
            BankAccount bankAccount=new BankAccount(account,balace);
            Hotel hotel=new Hotel(account, name, location, bankAccount);
            this.dataBase.accountRepositery.addObject(account.getId(), account);
            this.dataBase.cityRepositery.addObject(city.getId(), city);
            this.dataBase.locationRepositery.addObject(location.getId(),location);
            this.dataBase.bankAccountRepositery.addObject(bankAccount.getId(), bankAccount);
            this.dataBase.hotelRepositery.addObject(hotel.getId(), hotel);
        }
        catch(Exception e){ System.out.println(e.getMessage());}
    }

    public Customer loginCustomer(String email, String password){
        try{
            Account ac=this.dataBase.accountRepositery.findByEmail(email);
            String accountPassword=decrypt(ac.getPassword());
            if(accountPassword.equals(password)){
                Customer customer=this.dataBase.customerRepositery.getCustomerByAccount(ac);
                return customer;
            }
            return null;
        }
        catch(Exception e){ 
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Admin loginAdmin(String email, String password){
        try{
            Account ac=this.dataBase.accountRepositery.findByEmail(email);
            String accountPassword=decrypt(ac.getPassword());
            if(accountPassword.equals(password)){
                Admin admin=this.dataBase.adminRepositery.getAdminByAccount(ac);
                return admin;
            }
            return null;
        }
        catch(Exception e){ System.out.println(e.getMessage());return null;}
    }
    public Hotel loginHotel(String email, String password){
        try{
            Account ac=this.dataBase.accountRepositery.findByEmail(email);
            String accountPassword=decrypt(ac.getPassword());
            if(accountPassword.equals(password)){
                Hotel hotel=this.dataBase.hotelRepositery.getHotelByAccount(ac);
                return hotel;
            }
            return null;
        }
        catch(Exception e){ System.out.println(e.getMessage());return null;}
    }

}
