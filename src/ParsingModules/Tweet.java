package ParsingModules;

import Parsing.Methods;

/**
 * Created by roland1996 on 30.03.2016.
 */
public class Tweet implements IRecordParser<Modules.Tweet> {
    @Override
    public Modules.Tweet parser(String line) {
        return new Modules.Tweet(
                Methods.getCoordinate(line),
                Methods.getDate(line),
                Methods.getMessageForTweet(line));
    }
}