package ParsingModules;

import Parsing.Methods;

/**
 * Created by roland1996 on 30.03.2016.
 */
public class Sentiment implements IRecordParser<Modules.Sentiment>{
    @Override
    public Modules.Sentiment parser(String line){
        return new Modules.Sentiment(
                Methods.getWordForSentiment(line),
                Methods.getEmotionalWeightForSentiment(line));
    }
}
