package sample;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.awt.*;

class MainTest {

   static Label totalLabelY = new Label("Test");
    String totalLabelString = "Test";
  static   Label person0 = new Label("Donald Person Test");
    String personString = "Donald Person Test";


    public static String getValue1(){   // getValue0 method
        String a =  totalLabelY.getText();
        return a;
    }
    public static String getPerson1(){   // getPerson0 method
        String a = person0.getText();
        return a;
    }





    @Test
    void getValue0() {
       Assert.assertEquals(totalLabelString,getValue1());       // tests this getter for value of a Label
    }


    @Test
    void getPerson0() {
        Assert.assertEquals(personString,getPerson1());
    }   // tests getter for value of a Label

}