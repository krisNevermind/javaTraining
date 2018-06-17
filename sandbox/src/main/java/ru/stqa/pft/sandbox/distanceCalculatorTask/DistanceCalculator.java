package ru.stqa.pft.sandbox.distanceCalculatorTask;

public class DistanceCalculator {

    public static double distanceCalc(Point p1, Point p2){
        return Math.sqrt(((p2.x-p1.x)*(p2.x-p1.x))+((p2.y-p1.y)*(p2.y-p1.y)));

    }
}
