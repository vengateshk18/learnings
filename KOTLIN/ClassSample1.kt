class Employee(var empId:Int, var empName:String, var empDept: String){
    fun getName():String{
        return this.empName;
    }
}

public fun main(){
    val obj=Employee(10,"venky","android")
    print(obj.getName())
}