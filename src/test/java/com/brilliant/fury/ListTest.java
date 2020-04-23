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
}
