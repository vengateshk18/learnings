class Employee{
    private var empId:Int
    private var empName:String

    constructor(empId:Int,empName:String){
        this.empId=empId
        this.empName=empName
    }

    public fun getName():String{
        return this.empName
    }

    public fun getEmpId():Int{
        return this.empId;
    }
}

public fun main(){
    var obj=Employee(10,"venky")
    println(obj.getName())
    println(obj.getEmpId())
}