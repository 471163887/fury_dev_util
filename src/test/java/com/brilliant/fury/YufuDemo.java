package com.brilliant.fury;

import com.brilliant.fury.util.GuavaUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试
 */
public class YufuDemo {

    private static final Logger log = LoggerFactory.getLogger(YufuDemo.class);

    /**
     * 字母异位词分组
     给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     输出:
     [
     ["ate","eat","tea"],
     ["nat","tan"],
     ["bat"]
     ]
     */
    @Test
    public void test() {
        Map<String, List<String>> strMap = Maps.newHashMap();

        List<String> input = Lists.newArrayList("eat", "tea", "tan", "ate", "nat", "bat");
        for (String str : input) {
            String sorted = sortStr(str);
            if (strMap.containsKey(sorted)) {
                strMap.get(sorted).add(str);
            } else {
                ArrayList<String> strings = Lists.newArrayList(str);
                strMap.put(sorted, strings);
            }
        }
        log.info("result is:{}", strMap.values());
    }

    private String sortStr(String str) {
        return GuavaUtil.sortString(str);
    }

    public static void main(String[] args) {
        String s1 = "AB";
        String s2 = new String("AB");
        String s3 = "A";
        String s4 = "B";
        String s5 = "A" + "B";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
    }

}
