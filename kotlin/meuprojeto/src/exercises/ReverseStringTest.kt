package exercises;

import org.junit.Assert;
import org.junit.Test;

public class ReverseStringTest {

    @Test
    fun reverseUsingSB (){

        Assert.assertEquals("BS niltoK", reverseUsingSB("Kotlin SB"))
        }

    @Test
    fun reverseUsingLoop(){

        Assert.assertEquals("pooL niltoK", reverseUsingLoop("Kotlin Loop"))
    }
}
