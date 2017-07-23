package exercises


    fun reverseUsingSB (str:String): String {
        return StringBuilder(str).reverse().toString()
    }

    fun reverseUsingLoop (str:String): String {
        var x = 1
        var strResult:String = ""
        for(x in (str.length - 1) downTo 0){
            strResult = strResult + str[x]
        }
        return strResult
    }