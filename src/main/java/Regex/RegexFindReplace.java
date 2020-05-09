package Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFindReplace {
    public static void main(String args[]) {
        // The regex pattern
        //final String REGEX_PATTERN = "([0-9]+)x([0-9]+)";regex 25
        //final String REGEX_PATTERN = "([a-zA-Z]+)\\s([a-zA-Z]+)"; regex 26
        //final String REGEX_PATTERN = "([0-9]{1,2}):([0-9]{2})";regex 27
        //final String REGEX_PATTERN = "([0-9]{3})\\.([0-9]{3})\\.([0-9]{4})"; regex 28
        //final String REGEX_PATTERN = "([a-zA-Z]{3})\\s([0-9]{1,2})[a-z]{2}\\s[0-9]{2}([0-9]{2})";regex 29
        final String REGEX_PATTERN = "\\(([0-9]{3})\\)\\.([0-9]{3})\\.([0-9]{4})";
        final String inputFileName = "ExerciseInputFiles/regex30.txt";
        // Create a Pattern object
        Pattern r = Pattern.compile(REGEX_PATTERN);

        // Read the input file line by line
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(RegexFindReplace.class.getClassLoader().getResourceAsStream(inputFileName)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                // Now create matcher object.
                Matcher m = r.matcher(line);

                // Apply the regex pattern to each line
                // If pattern matches, perform replacement on the current line.
                if (m.find()) {
                    //line = m.replaceAll(m.group(1) + " pix by " + m.group(2) + " pix");regex 25
                    //line = m.replaceAll(m.group(2)+","+m.group(1));regex 26
                    //line = m.replaceAll(m.group(2)+" mins past "+m.group(1));regex 27
                    //line = m.replaceAll("xxx.xxx."+m.group(3)); regex 28
                    //line = m.replaceAll(m.group(2)+"-"+m.group(1)+"-"+m.group(3));regex 29
                    line = m.replaceAll(m.group(1)+"."+m.group(2)+"."+m.group(3));
                    System.out.println(line);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
