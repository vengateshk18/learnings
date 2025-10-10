class Employee{
    private var id:Int=0
    private var availableStatus:Boolean=false

    fun checkIn(): Int{
        this.availableStatus=true
        return 1
    }
    fun checkOut(): Int{
        this.availableStatus=false;
        return 1
    }
}

public fun main(){
    var onj:Employee=Employee()
    print(onj.checkIn())
}