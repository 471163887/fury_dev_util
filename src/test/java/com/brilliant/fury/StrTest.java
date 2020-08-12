package com.brilliant.fury;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author by fury.
 * version 2020/4/20.
 */
public class StrTest {

    private static final Logger log = LoggerFactory.getLogger(StrTest.class);

    @Test
    public void test() throws Exception {
        String input = "abcde";
        String result = diguiStrReverse(input);
        log.info("result :{}", result);
    }

    public String diguiStrReverse(String input) {
        int length = input.length();
        if (length <= 1) {
            return input;
        }
        int end = length - 1;
        if (end > 1) {
            String sub = input.substring(1, end);
            String diguiStr = diguiStrReverse(sub);
            return input.charAt(end) + diguiStr + input.charAt(0);
        }
        return input;
    }

    /**
     * 水仙花数是指一个 n 位数 ( n≥3 )，它的每个位上的数字的 n 次幂之和等于它本身。
     * （例如：1^3 + 5^3 + 3^3 = 153，1634 = 1^4 + 6^4 + 3^4 + 4^4）。给出一个整数M，求 >= M的最小的水仙花数。
     */
    @Test
    public void test2() throws Exception {
        int n = 1633;
        int result;
        while (true) {
            boolean isOk = getShuixianhuashu(n);
            if (isOk) {
                result = n;
                break;
            }
            n++;
        }
        log.info("result :{}", result);
    }

    private boolean getShuixianhuashu(int n) {
        int sum = 0;

        int div10 = n;
        int gewei = n % 10;

        while (div10 >= 1) {
            int current = div10 % 10;
            int temp = 1;
            for (int i = 0; i < gewei; ++i) {
                temp = temp * current;
            }
            sum += temp;
            div10 = div10 / 10;
        }
        return sum == n;
    }

    @Test
    public void test3() throws Exception {
        int i = 5 / 10;
        log.info("{}", i);
    }

}
