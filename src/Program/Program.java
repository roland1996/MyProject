package Program;

import Parsing.Methods;

/**
 * Created by roland1996 on 30.03.2016.
 */
public class Program {
    private int numberReport;
    private java.util.List<String> textAllTweets;
    private java.util.List<String> textAllSentiments;
    private java.util.List<String> textAllStates;

    private java.util.List<Modules.Tweet> allTweets;
    private java.util.List<Modules.Sentiment> allSentiments;
    private java.util.List<Modules.State> allStates;

    private void runInitializeAllTweets() {
        this.allTweets = new java.util.ArrayList<Modules.Tweet>();
        ParsingModules.IRecordParser<Modules.Tweet> item = new ParsingModules.Tweet();
        for (String line :
                this.textAllTweets) {
            this.allTweets.add(item.parser(line));
        }
    }

    private void runInitializeAllSentiments() {
        this.allSentiments = new java.util.ArrayList<Modules.Sentiment>();
        ParsingModules.IRecordParser<Modules.Sentiment> item = new ParsingModules.Sentiment();
        for (String line :
                this.textAllSentiments) {
            this.allSentiments.add(item.parser(line));
        }
    }

    private void runInitializeAllStates() {
        this.allStates = new java.util.ArrayList<Modules.State>();
        java.util.List<String> allStringCoordinates = Methods.getAllStringItemsForStatesCoordinates(this.textAllStates.get(0));
        java.util.List<String> allStringNames = Methods.getAllStringItemsForStatesNames(this.textAllStates.get(0));
        ParsingModules.IRecordParser<Modules.State> item = new ParsingModules.State();
        for(int i = 0; i < allStringCoordinates.size(); i++){
            this.allStates.add(item.parser(allStringNames.get(i) + allStringCoordinates.get(i)));
        }
    }

    private void runInitializeFirstReport(){

    }

    private void runInitialize(){
        this.runInitializeAllTweets();
        this.runInitializeAllSentiments();
        this.runInitializeAllStates();
    }

    public Program(java.util.List<String> textAllTweets, java.util.List<String> textAllSentiments, java.util.List<String> textAllStates, int numberReport){
        this.textAllSentiments = textAllSentiments;
        this.textAllStates = textAllStates;
        this.textAllTweets = textAllTweets;
        this.numberReport = numberReport;
        this.runInitialize();

    }
}