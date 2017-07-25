package exercises

import org.junit.Assert
import org.junit.Test

class VowelCosonantTest {

    @Test
    fun countVowels (){
        Assert.assertEquals(11, countVowels ("Quantas vogais tem esta frase!"))
    }

    @Test
    fun countCosonants (){
        Assert.assertEquals(20, countCosonants("Geralmente uma frase tem mais consoantes"))
    }

    @Test
    fun countVowelsAndCosonants (){
        val str="Estou gostando muito de aprender kotlin"

        Assert.assertEquals(15, countVowels(str))
        Assert.assertEquals(19,countCosonants(str))

    }
}