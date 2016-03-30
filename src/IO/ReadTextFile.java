package IO;

/**
 * Created by roland1996 on 30.03.2016.
 */
public class ReadTextFile {
    public static void getText(java.util.List<String> Text, String fileName, int numberStartingLine, int numberOutputLines) throws java.io.IOException {
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(fileName)));
        String line;
        int count = 0;
        while ((line = reader.readLine()) != null && count != numberOutputLines + 1) {
            if (count == numberStartingLine) {
                Text.add(line);
                for (int i = 0; i < numberOutputLines; i++) {
                    if ((line = reader.readLine()) != null) {
                        Text.add(line);
                    } else {
                        i = numberOutputLines;
                        count = numberStartingLine;
                    }
                }
            }
            count++;
        }
        reader.close();
    }

    public static void getAllText(java.util.List<String> text, String fileName) throws java.io.IOException {
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(fileName)));
        String line;
        while ((line = reader.readLine()) != null) {
            text.add(line);
        }
        reader.close();
    }

}
