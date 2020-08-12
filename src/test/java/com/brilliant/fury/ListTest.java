package com.brilliant.fury;

import com.google.common.collect.Lists;
import java.util.List;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author by fury.
 * version 2020/4/20.
 */
public class ListTest {

    private static final Logger log = LoggerFactory.getLogger(ListTest.class);

    @Test
    public void cleanTest() throws Exception {
        List<String> list = Lists.newArrayList("aa", "bb");
        List<String> listb = Lists.newArrayList( "bb");
        // list.clear();
        log.info("resp:{}", list.size());
        list.removeAll(listb);
        log.info("list:{}", list);
        //list = null;
        //log.info("resp:{}", list.size());
    }

    @Test
    public void LongTest() throws Exception {
        Long a = 100L;
        log.info("a.toString={}", a.toString());
    }

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println("Hello World!");
        String str1 = "abcde";
        String str2 = "bcd";
        int maxLen = findMaxSubStringLength(str1, str2);
        System.out.println("maxLen is:" + maxLen);
    }

    public  static int findMaxSubStringLength(String str1, String str2) {
        String longStr;
        String shortStr;
        if(str1.length() > str2.length()) {
            longStr = str1;
            shortStr = str2;
        } else{
            longStr = str2;
            shortStr = str1;
        }
        if(longStr.contains(shortStr)) {
            return shortStr.length();
        }
        return findSubStringLength(longStr, shortStr);
    }

    public static int findSubStringLength(String longStr, String shortStr) {
        int maxLen = 0;
        int shotrLen = shortStr.length();
        for(int index = 0; index < shotrLen; ++index) {
            String subString = getSubString(longStr, shortStr, index, shotrLen);
            if(null == subString) {
                continue;
            }
            int subLen = subString.length();
            maxLen = subLen > maxLen ? subLen : maxLen;
        }

        return maxLen;
    }

    public static String getSubString(String longStr, String shortStr, int index, int shotrLen) {
        int maxIndex = shotrLen;
        while(maxIndex > index) {
            String tempStr = shortStr.substring(index, maxIndex);
            if(longStr.contains(tempStr)) {
                return tempStr;
            }
            maxIndex--;
        }
        return null;
    }
}
