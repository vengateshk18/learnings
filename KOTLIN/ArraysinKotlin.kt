public fun main(){
    var arr=arrayOf("venky",10,21)
    var arr2=arrayOf<Int>(1,2,3)
    arr[0]=5
    arr.set(1,100)
    println(arr[0])
    println(arr[1])
    println(arr.get(2))
    println(arr2[0])
}