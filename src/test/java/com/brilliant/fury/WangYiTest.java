package com.brilliant.fury;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author by fury.
 * version 2020/4/20.
 */
public class WangYiTest {

    private static final Logger log = LoggerFactory.getLogger(WangYiTest.class);

    @Test
    public void test() {
        String a = "  hello         world, aaa    bb ccc   ";
        char[] words = a.trim().toCharArray();
        processWords(words);
        String result = String.valueOf(words);
        log.info("after process :{} ", result);
    }
    /**
     * 有char型数组words，由空格以及字母组成。 我们定义被空格隔离开的字符序列为一个单词。
     * 现需要对其处理，把连续的空格换成一个空格，把单词的首字母大写。
     * 要求：1. 在原有数组上操作，不得开辟新的数组空间。 2. 性能也要考虑优化。
     * void processWords(char[] words)
     */
    public void processWords(char[] words) {
        // 头部有几个空格就移动几次
        int len = words.length;
        int moveStep = 0;
        for (int i = 0; i < len; ) {
            int wordStart = i;
            int nextSpace = i + 1;
            if (nextSpace >= len) {
                return;
            }
            // 找到单词下一个空格的位置
            for (int j = nextSpace; j < len; ++j) {
                Character word = words[j];
                if (Character.isWhitespace(word)) {
                    nextSpace = j;
                    break;
                }
            }
            // 首字母大写
            char word = words[wordStart];
            words[wordStart] = toUp(word);

            // 移动单词
            if (moveStep > 0) {
                for (int c = wordStart; c < nextSpace; ++c) {
                    char wordTemp = words[c];
                    words[c - moveStep] = wordTemp;
                }
            }

            // 计算多余的空格数
            int k = nextSpace + 1;
            for (; k < len; ++k) {
                if (words[k] == ' ') {
                    ++moveStep;
                } else {
                    i = k;
                    break;
                }
            }
            // 没有多余的空格处理
            if (i != k) {
                i = nextSpace + 1;
            }
        }
    }

    private char toUp(char word) {
        return Character.toUpperCase(word);
    }

}
