package exercises

fun countVowels(str: String): Int {

    var nVowels: Int = 0
    val VOWELS = "aeiou"
    var aux = str.toLowerCase()

    for (letter in aux){
        if(letter in VOWELS)  nVowels++;
    }

    return nVowels
}

fun countCosonants(str: String): Int {

    var nCosonants: Int = 0
    val CONSONANTS = "qwrtypsdfghjklzxcvbnm"
    var aux = str.toLowerCase()

    for (letter in aux){
        if(letter in CONSONANTS)  nCosonants++;
    }


    return nCosonants
}