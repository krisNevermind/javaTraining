package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.distanceCalculatorTask.PointEdited;

public class DistanceCalcTestEdited{

 @Test
 public void testDistanceCalc() {

     PointEdited p1 = new PointEdited(1, 2);

     PointEdited p2 = new PointEdited(5,7);

     double distLength = p1.distanceCalc(p2);
     Assert.assertEquals(distLength, 6.4031242374328485);
 }
}
