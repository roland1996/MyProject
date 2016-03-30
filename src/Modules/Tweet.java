package Modules;

/**
 * Created by roland1996 on 30.03.2016.
 */
public class Tweet {
    private Coordinate coordinate;
    private java.util.Date date;
    private String message;
    public Tweet(){}
    public Tweet(Coordinate coordinate, java.util.Date date, String message){
        this.coordinate = coordinate;
        this.date = date;
        this.message = message;
    }
    public Coordinate getCoordinate(){
        return this.coordinate;
    }
    public java.util.Date getDate(){
        return this.date;
    }
    public String getMessage(){
        return this.message;
    }
    @Override
    public String toString(){
        StringBuilder line = new StringBuilder();
        line.append(this.message + " " + this.date.toString() + " " + this.coordinate.toString());
        return line.toString();
    }
}