package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChallenge {
    public static void main(String[] args) {
        String challenge1 = "I want a bike";
        String regExp = "I want a \\w+.";
        System.out.println(challenge1.matches(regExp));

        String regexExp3 = "I want a \\w+.";
        Pattern pattern = Pattern.compile(regexExp3);
        Matcher matcher = pattern.matcher(challenge1);
        System.out.println(matcher.matches());

        String challenge4 = "replace all places with underscores";
        System.out.println(challenge4.replaceAll("\\s","_"));

        String challenge5 = "aaabccccccddddddeffffggg";
        System.out.println(challenge5.matches("[a-g]+"));

        //match the challenge 5 entity
        System.out.println(challenge5.matches("^a{3}bc{6}d{6}ef{4}g{3}$"));
        System.out.println(challenge5.replaceAll("^a{3}bc{6}d{6}ef{4}g{3}$", "REPLACED"));

        String challenge6 = "abcd.125";
        System.out.println(challenge6.matches("^[A-z][a-z]+\\.\\d+$"));

        String challenge7 = "abcd.135uvqz.7tzik.999";
        Pattern pattern2 = Pattern.compile("[A-Za-z]+\\.(\\d+)");
        Matcher matcher2 = pattern2.matcher(challenge7);
        while(matcher2.find()){
            System.out.println("Occurance: " + matcher2.group(1));
        }

        String challenge8 = "abcd.135\tuvqz.7\ttzik.999\n";
        Pattern pattern3 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher matcher3 = pattern3.matcher(challenge8);
        while(matcher3.find()){
            System.out.println("Occurance: " + matcher3.group(1));
        }

        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        Pattern pattern4 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher matcher4 = pattern3.matcher(challenge9);
        while(matcher4.find()){
            System.out.println("Occurance: " + "start: "+ matcher4.start(1) +" end: "+ (matcher4.end(1)-1));
        }

        //? is the lazy qualifier
        String challenge10 = "{0,2},{0,5},{1,3},{2,4}";
        Pattern pattern5 = Pattern.compile("\\{(.+?)\\}");
        Matcher matcher5 = pattern5.matcher(challenge10);

        while(matcher5.find()){
            System.out.println("Occurance: " + matcher5.group(1));
        }

        String challenge11 = "{0,2},{0,5},{1,3},{2,4} {x,y},{6,34},{11,12}";
        Pattern pattern6 = Pattern.compile("\\{(\\d+,\\d+)\\}");
        Matcher matcher6 = pattern6.matcher(challenge11);

        while(matcher6.find()){
            System.out.println("Occurance: " + matcher6.group(1));
        }

        String challenge12 = "11111";
        System.out.println(challenge12.matches("^\\d{5}$"));

        String challenge13 = "11111-1111";
        System.out.println(challenge13.matches("^\\d{5}-\\d{4}$"));

        //make challenge12 and 13 both work
        //? mark for 0 or 1 occurance
        System.out.println(challenge12.matches("^\\d{5}(-\\d{4})?$"));
        System.out.println(challenge12.matches("^\\d{5}(-\\d{4})?$"));

    }


}
