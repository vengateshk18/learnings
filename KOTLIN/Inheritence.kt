open class Employee(var empId:Int,var empName:String){
    public fun getid():Int{
        return this.empId
    }
}

class Manager(var managerId:Int,empId:Int,empName:String):Employee(empId,empName){
    public fun getManagerIdData():Int{
        return this.managerId;
    }
}

public fun main(){
    var obj=Manager(10,10,"venky")
    println(obj.getid())
}