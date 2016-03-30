package ParsingModules;

import Parsing.Methods;

/**
 * Created by roland1996 on 30.03.2016.
 */
public class State implements IRecordParser<Modules.State> {
    @Override
    public Modules.State parser(String line) {
        return new Modules.State(
                line.substring(0, 2),
                Methods.getAllCoordinates(line));
    }
}
