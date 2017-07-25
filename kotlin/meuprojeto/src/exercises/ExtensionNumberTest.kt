package exercises

import org.junit.Assert
import org.junit.Test

class ExtensionNumberTest {

    @Test
    fun percentOf () {
        Assert.assertEquals(10.0f, 10.0f.percentOf(100.0f), .01f)
    }
}

    @Test
        fun percentOFNumberCustomPrecision (){
        Assert.assertEquals(0.036, 33.0f.percentOf(91919.0f).customPrecision(2))
    }