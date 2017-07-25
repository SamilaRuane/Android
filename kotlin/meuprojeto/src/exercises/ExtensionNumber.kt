package exercises

import java.math.BigDecimal
import java.math.RoundingMode

fun Float.percentOf (num:Float) : Float {

    var result: Float
    val PERCENT = 100
    result = (this * num) / PERCENT

    return result

}

fun Float.customPrecision (precision:Int) : Float = BigDecimal(this.toString()).setScale(precision, RoundingMode.HALF_UP).toFloat()
