package com.brilliant.fury;

import com.google.common.collect.Lists;
import java.util.List;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author by fury.
 * version 2020/4/16.
 */
public class ByteDance {

    private static final Logger log = LoggerFactory.getLogger(ByteDance.class);

    /**
     * 给的一个无序正整数数组，找出数组中每个元素右边第一个比它大的数字，没有输出-1
     * IN:  [2, 1, 3, 2,  5,  2]
     * OUT: [3, 3, 5, 5, -1, -1]
     */
    @Test
    public void rightMaxTest() {
        List<Integer> list = Lists.newArrayList(2, 1, 3, 2, 5, 2);
        List<Integer> result = getRightMax(list);
        log.info("result is:{}", result);
    }

    private List<Integer> getRightMax(List<Integer> list) {
        List<Integer> result = Lists.newArrayList();
        int size = list.size();
        for (int i = 0; i < size; ++i) {
            Integer current = list.get(i);
            Integer indexResult = getIndexResult(current, list.subList(i + 1, size));
            result.add(indexResult);
        }
        return result;
    }

    private Integer getIndexResult(Integer current, List<Integer> subList) {
        int subSize = subList.size();
        for (int j = 0; j < subSize; ++j) {
            Integer tempInt = subList.get(j);
            if (tempInt > current) {
                return tempInt;
            }
        }
        return -1;
    }
}
