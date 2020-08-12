package com.brilliant.fury;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试
 */
public class MeituanDemo {

    private static final Logger log = LoggerFactory.getLogger(MeituanDemo.class);

    @Test
    public void test() {
        String a = "1111";
        String b = "99999999";
        String c = bigAdd(a, b);
        System.out.println("big add result : " + c);
    }

    private String bigAdd(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        char[] maxChars;
        char[] minChars;
        if (aChars.length > bChars.length) {
            maxChars = aChars;
            minChars = bChars;
        } else {
            maxChars = bChars;
            minChars = aChars;
        }
        int[] maxInts = char2Int(maxChars);
        int[] minInts = char2Int(minChars);
        int[] resultInt = bigAddInt(maxInts, minInts);
        char[] resultChar = int2Char(resultInt);
        return String.valueOf(resultChar);
    }

    private int[] bigAddInt(int[] maxInts, int[] minInts) {
        int jinwei = 0;
        int[] ints = new int[maxInts.length + 1];
        int i = 0;
        for (; i < minInts.length; ++i) {
            int min = minInts[i];
            int max = maxInts[i];
            int result = jinwei + min + max;
            if (result > 9) {
                jinwei = 1;
                result = result - 10;
            } else {
                jinwei = 0;
            }
            ints[i] = result;
        }
        while (i < maxInts.length) {
            int result = jinwei + maxInts[i];
            if (result > 9) {
                jinwei = 1;
                result = result - 10;
            } else {
                jinwei = 0;
            }
            ints[i] = result;
            ++i;
        }
        if (jinwei == 1) {
            ints[i] = 1;
        }
        return ints;
    }

    private char[] int2Char(int[] resultInt) {
        char[] chars = new char[resultInt.length];
        int endIndex = resultInt.length - 1;
        for (int i = 0; i < resultInt.length; ++i) {
            chars[endIndex] = (char)(resultInt[i] + '0');
            --endIndex;
        }
        return chars;
    }

    private int[] char2Int(char[] chars) {
        int len = chars.length;
        int[] ints = new int[len];
        int intsIndex = 0;
        for (int i = len - 1; i >= 0; i--) {
            int anInt = Integer.parseInt(String.valueOf(chars[i]));
            ints[intsIndex] = anInt;
            ++intsIndex;
        }
        return ints;
    }

}
