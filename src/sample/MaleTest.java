package sample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaleTest {
    Male male = new Male("Male Person","30","Seattle");


    @Test
    void getCity() {
        assertEquals("Seattle",male.getCity());
    }   // tests getCity() method
}