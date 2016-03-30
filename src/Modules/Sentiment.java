package Modules;

/**
 * Created by roland1996 on 30.03.2016.
 */
public class Sentiment {
    private String word;
    private double emotionalWeight;
    public Sentiment(){}
    public Sentiment(String word, double emotionalWeight){
        this.word = word;
        this.emotionalWeight = emotionalWeight;
    }
    public String getWord(){
        return this.word;
    }
    public double getEmotionalWeight(){
        return this.emotionalWeight;
    }

    @Override
    public String toString(){
        StringBuilder line = new StringBuilder();
        line.append(this.word + " " + this.emotionalWeight);
        return line.toString();
    }
}
