package Modules;

/**
 * Created by roland1996 on 30.03.2016.
 */
public class Coordinate {
    private double x;
    private double y;
    public Coordinate(){}
    public Coordinate(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    @Override
    public String toString(){
        StringBuilder line = new StringBuilder();
        line.append(this.x + " " + this.y);
        return line.toString();
    }
}