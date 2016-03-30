package Parsing;

import Modules.Coordinate;

/**
 * Created by roland1996 on 30.03.2016.
 */
public class Methods {

    public static java.lang.String getMessageForTweet(java.lang.String line) {
        java.lang.StringBuilder message = new java.lang.StringBuilder();
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\p{Digit}{2}(:\\p{Digit}{2}){2}");
        java.util.regex.Matcher matcher = pattern.matcher(line.toString());
        if (matcher.find()){
            message.append(line.substring(matcher.end() + 1, line.length()));
        }
        return message.toString();
    }

    public static java.util.Date getDate(java.lang.String line) {
        java.util.regex.Pattern pattern1 = java.util.regex.Pattern.compile("\\p{Digit}{4}(-\\p{Digit}{2}){2}");
        java.util.regex.Pattern pattern2 = java.util.regex.Pattern.compile("\\p{Digit}{2}(:\\p{Digit}{2}){2}");
        java.util.regex.Matcher matcher1 = pattern1.matcher(line.toString());
        java.util.regex.Matcher matcher2 = pattern2.matcher(line.toString());
        java.util.Date date = new java.util.Date();
        if (matcher1.find()){
            date.setYear(Integer.parseInt(matcher1.group(0).substring(0, 4)));
            date.setMonth(Integer.parseInt(matcher1.group(0).substring(5, 7)));
            date.setDate(Integer.parseInt(matcher1.group(0).substring(8, 10)));
        }
        if (matcher2.find()){
            date.setHours(Integer.parseInt(matcher2.group(0).substring(0, 2)));
            date.setMinutes(Integer.parseInt(matcher2.group(0).substring(3, 5)));
            date.setSeconds(Integer.parseInt(matcher2.group(0).substring(6, 8)));
        }
        return date;
    }

    public static Coordinate getCoordinate(java.lang.String line) {
        String x = "", y = "";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("-{0,1}\\p{Digit}+\\.{1}\\p{Digit}+");
        java.util.regex.Matcher matcher = pattern.matcher(line.toString());
        if (matcher.find()) { x = matcher.group();}
        if (matcher.find()) { y = matcher.group();}
        return new Coordinate(Double.parseDouble(x), Double.parseDouble(y));
    }

    public static java.util.List<String> getAllStringItemsForStatesCoordinates(java.lang.String line){
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\p{Alpha}{2}");
        String[] arr =  pattern.split(line);
        java.util.List<String> array = new java.util.ArrayList<String>();
        for( int i = 1; i < arr.length; i++)
            array.add(arr[i]);
        return array;
    }

    public static java.util.List<String> getAllStringItemsForStatesNames(java.lang.String line){
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\p{Alpha}{2}");
        java.util.regex.Matcher matcher = pattern.matcher(line);
        java.util.List<String> array = new java.util.ArrayList<String>();
        while(matcher.find()) {
            array.add(matcher.group());
        }
        return array;
    }

    public static java.util.List<Coordinate> getAllCoordinates(java.lang.String line) {
        java.util.List<Coordinate> allCoordinates = new java.util.ArrayList<Coordinate>();
        java.util.List<String> array = new java.util.ArrayList<String>();
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("-{0,1}\\p{Digit}+\\.{1}\\p{Digit}+");
        java.util.regex.Matcher matcher = pattern.matcher(line.toString());
        while (matcher.find()) {
            array.add(matcher.group());
        }
        for (int i = 0; i < array.size(); i+=2){
            allCoordinates.add(new Coordinate(Double.parseDouble(array.get(i)), Double.parseDouble(array.get(i + 1))));
        }
        return allCoordinates;
    }

    public static java.lang.Double getEmotionalWeightForSentiment(java.lang.String line){
        java.lang.Double emotionalWeight = 0.0;
        int index = line.indexOf(',');
        if(index != -1){
            emotionalWeight = Double.parseDouble(line.substring(index + 1, line.length()));
        }
        return emotionalWeight;
    }

    public static java.lang.String getWordForSentiment(java.lang.String line){
        java.lang.StringBuilder word = new java.lang.StringBuilder();
        int index = line.indexOf(',');
        if(index != -1){
            word.append(line.substring(0, index));
        }
        return word.toString();
    }
}