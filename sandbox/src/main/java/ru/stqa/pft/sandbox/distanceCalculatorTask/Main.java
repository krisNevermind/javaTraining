package ru.stqa.pft.sandbox.distanceCalculatorTask;

public class Main {

    public static void main(String[] args) {

        Point p1 = new Point();
        p1.x = 1;
        p1.y= 2;

        Point p2 = new Point();
        p2.x = 5;
        p2.y = 7;

        double distLength = DistanceCalculator.distanceCalc(p1, p2);
        System.out.println(distLength);
    }
}
