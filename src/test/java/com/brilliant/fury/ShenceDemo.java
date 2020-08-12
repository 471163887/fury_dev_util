package com.brilliant.fury;

import com.brilliant.fury.util.GuavaUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试
 */
public class ShenceDemo {

    private static final Logger log = LoggerFactory.getLogger(ShenceDemo.class);

    /**
     * 打印一个最后数值小于 N 的斐波那契数列
     */
    @Test
    public void test() {
        int n = 5;
        List<Integer> result = genFeibonaqiList(5);
        log.info("[result is {}]", result);
    }

    private List<Integer> genFeibonaqiList(int n) {
        List<Integer> result = Lists.newArrayList();
        if (n < 1) {
            return result;
        }
        result.add(1);
        if (n == 1) {
            return result;
        }
        result.add(1);
        if (n == 2 ) {
            return result;
        }
        int start =  0;
        int end = 1;
        int current = 2;
        while (current < n) {
            result.add(current);
            ++start;
            ++end;
            current = result.get(start) + result.get(end);
        }
        return result;
    }

    @Test
    public void test2() {

    }

}
