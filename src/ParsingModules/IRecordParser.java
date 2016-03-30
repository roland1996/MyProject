package ParsingModules;

/**
 * Created by roland1996 on 30.03.2016.
 */
public interface IRecordParser<Type> {
    Type parser(String line);
}
