package ru.stqa.pft.sandbox.distanceCalculatorTask;

public class PointEdited {
    public int x;
    public int y;

    public PointEdited(int x, int y){
        this.x=x;
        this.y=y;
}

    public double distanceCalc(PointEdited p2){
        return Math.sqrt(((p2.x-this.x)*(p2.x-this.x))+((p2.y-this.y)*(p2.y-this.y)));

    }

}