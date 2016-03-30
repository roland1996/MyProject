package Modules;

/**
 * Created by roland1996 on 30.03.2016.
 */
public class State {
    private String nameState;
    private java.util.List<Coordinate> arrayCoordinate;
    public State(){}
    public State(String nameState, java.util.List<Coordinate> arrayCoordinate){
        this.nameState = nameState;
        this.arrayCoordinate = arrayCoordinate;
    }
    public String getNameState(){
        return this.nameState;
    }
    public  java.util.List<Coordinate> getArrayCoordinate(){
        return this.arrayCoordinate;
    }
    @Override
    public String toString(){
        StringBuilder line = new StringBuilder();
        line.append(this.nameState + "\n");
        for (Coordinate item:
                this.arrayCoordinate) {
            line.append(item.toString() + "\n");
        }
        return line.toString();
    }
}
