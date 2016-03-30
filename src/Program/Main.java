package Program;

/**
 * Created by roland1996 on 30.03.2016.
 */
import IO.ReadTextFile;

public class Main {
    static String stateFileName = "D:\\учёба 2 семестр 4\\Технологии разработки платформенно-независимых приложений\\states.json";
    static String sentimentFileName = "D:\\учёба 2 семестр 4\\Технологии разработки платформенно-независимых приложений\\sentiments.csv";

    static String getFileName(String[] Args){
        StringBuilder fileName = new StringBuilder();
        for (int i = 3; i < Args.length; i++) {
            fileName.append(Args[i] + " ");
        }
        return fileName.toString();
    }

    public static void main(String[] Args)throws java.io.IOException{
        String fileName = getFileName(Args);
        int numberOutputLines = Integer.parseInt(Args[1]);
        int numberStartingLine = Integer.parseInt(Args[2]);

        java.util.List<String> textAllTweets = new java.util.ArrayList<String>();
        ReadTextFile.getText(textAllTweets, fileName.toString(), numberStartingLine, numberOutputLines);

        java.util.List<String> textAllSentiments = new java.util.ArrayList<String>();
        ReadTextFile.getAllText(textAllSentiments, sentimentFileName);

        java.util.List<String> textAllState = new java.util.ArrayList<String>();
        ReadTextFile.getAllText(textAllState, stateFileName);

        Program itemBaseClass = new Program(textAllTweets, textAllSentiments, textAllState, Integer.parseInt(Args[0]));

    }
}