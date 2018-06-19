package ru.stqa.pft.sandbox.distanceCalculatorTask;

public class MainEdited {

    public static void main(String[] args) {

        PointEdited p1 = new PointEdited(1, 2);

        PointEdited p2 = new PointEdited(5,7);


        System.out.println(p1.distanceCalc(p2));
    }
}
