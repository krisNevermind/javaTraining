package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.distanceCalculatorTask.DistanceCalculator;
import ru.stqa.pft.sandbox.distanceCalculatorTask.Point;

public class DistanceCalcTest {

    @Test
    public void testDistanceCalc() {
        Point p1 = new Point();
        p1.x = 1;
        p1.y= 2;

        Point p2 = new Point();
        p2.x = 5;
        p2.y = 7;

        double distLength = DistanceCalculator.distanceCalc(p1, p2);
        
        //assert distLength == 6.4031242374328485;
        Assert.assertEquals(distLength, 6.4031242374328485);
    }

}
