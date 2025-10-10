class Employee(empId:Int,empName:String){
    private var empId:Int
    private var empName:String
    init{
        this.empId=empId+10
        this.empName=empName.capitalize()
    }

    fun getName():String{
        return this.empName
    }
}

public fun main(){
    var obj=Employee(10,"venky")
    println(obj.getName())
}