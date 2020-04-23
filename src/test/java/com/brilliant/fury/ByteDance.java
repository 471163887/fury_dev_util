package com.brilliant.fury;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Stack;
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

    /**
     * 给定一个只包含三种字符的字符串：（ ，） 和 *，
     * 写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
     *
     * 1. 任何左括号 ( 必须有相应的右括号 )。
     * 2. 任何右括号 ) 必须有相应的左括号 ( 。
     * 3. 左括号 ( 必须在对应的右括号之前 )。
     * 4. * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
     * 5. 一个空字符串也被视为有效字符串。
     * 示例 1:
     *
     * 输入: "()"
     * 输出: True
     * 示例 2:
     *
     * 输入: "(*)"
     * 输出: True
     * 示例 3:
     *
     * 输入: "(*))"
     * 输出: True
     */
    @Test
    public void checkOkString() {
        List<String> demos = Lists.newArrayList(
            "()", "(*)", "(*))", "((*)", "()***", "()**(", "())", "*", "**()(");
        int size = demos.size();
        for (int i = 0; i < size; ++i) {
            Boolean demoRet = checkInput(demos.get(i));
            if (demoRet) {
                log.info("demo:{} Ret is:{}", i, "True");
            } else {
                log.info("demo:{} Ret is:{}", i, "False");
            }
        }
    }

    private Boolean checkInput(String inputString) {
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> startStack = new Stack<>();
        int length = inputString.length();
        for (int i = 0; i < length; ++i) {
            Character currentChar = inputString.charAt(i);
            if (currentChar == '(') {
                leftStack.push(currentChar);
            }
            if (currentChar == '*') {
                startStack.push(currentChar);
            }
            if (currentChar == ')') {
                if (leftStack.isEmpty()) {
                    if (startStack.isEmpty()) {
                        // 未能匹配右括号
                        return false;
                    } else {
                        startStack.pop();
                    }
                } else {
                    leftStack.pop();
                }
            }
        }
        // 若遍历结束后不存在左括号返回true，否则检查左括号和星号是否匹配
        if (leftStack.isEmpty()) {
            return true;
        } else {
            // 左括号之前的星号不能作为右括号。
            int firstLeft = inputString.indexOf("(");
            if (firstLeft >= 0) {
                return leftStack.size() == startStack.size() - firstLeft;
            } else {
                return leftStack.size() == startStack.size();
            }

        }
    }
}
