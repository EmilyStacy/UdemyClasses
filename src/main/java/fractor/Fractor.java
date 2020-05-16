package fractor;

import java.util.*;
import java.util.stream.Collectors;

public class Fractor {

    public static void main(String[] args) {
        long[][]lst = new long[][] { {1, 2}, {1, 3}, {10, 40} };
        System.out.println(convertFrac(lst));

    }

    //greatest common divider
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
        //10, 40
        //40,10
        //10,4

    }

    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public static String convertFrac(long[][] lst) {
        long lcmall = 1;
        long[][] newlst = new long[lst.length][2];
        for  (int i = 0; i < lst.length; i++) {
            long g = gcd(lst[i][0], lst[i][1]);
            newlst[i][0] = lst[i][0] / g;
            newlst[i][1] = lst[i][1] / g;
        }
        for (long[] item : newlst) {
            lcmall = lcm(lcmall, item[1]);
        }
        String result = "";
        for (long[] item : newlst) {
            result += "(" + (item[0] * lcmall / item[1]) + "," + lcmall + ")";
        }
        return result;
    }

}
