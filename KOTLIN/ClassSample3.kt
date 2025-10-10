

class Employee(private var age:Int, private var name:String){
    fun getName():String{
        return this.name;
    }
    fun getAge():Int{
        return this.age;
    }
}

public fun main(){
    var obj=Employee(10,"venky")
    println(obj.getName())
    println(obj.getAge())
}