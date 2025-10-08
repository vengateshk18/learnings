package HotelBookingApplication.repositery;

import java.util.*;

public abstract class Repositery<K,V> {
    private final HashMap<K,V> storage=new HashMap<>();

    public void addObject(K key, V value){
        this.storage.put(key,value);
    }

    public V getObject(K key){
        return this.storage.get(key);
    }

    public HashMap<K,V> getAllObjects(){
        return this.storage;
    }

    public Boolean isObjectAvailable(K key){
        return this.storage.containsKey(key);
    }

    public void removeIfAvailable(K key){
        if(isObjectAvailable(key)){
            this.storage.remove(key);
        }
    }

    public abstract void printAllObjects();
}
