package sample;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FemaleTest {
Female female = new Female("Female Person","30","Barcelona");
String name = "Female Person";



    @Test
    void getName() {
        Assert.assertEquals(female.getName(),name);  // tests getName() method
    }


}