package exercises

fun sumAllParameters (vararg number:Int) = number.sum()

fun <T> sumAllGenericParameters (vararg values:T): Double{

    var sum:Double = 0.0

    for (value in values){
        if (value is Int){
            sum += value;
        }else if (value is Double){
            sum += value
        }
    }
    return sum
}