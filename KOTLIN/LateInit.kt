
class Employee(var empId:Int,var empName:String){
    lateinit var empData:String;

    public fun getName():String{
        return this.empName;
    }
}


public fun main(){
    var obj=Employee(10,"venky");
    println(obj.getName())
    println(obj.empId)
}