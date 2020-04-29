package com.brilliant.fury;

import com.google.common.collect.Sets;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author by fury.
 * version 2020/4/20.
 */
public class MapTest {

    private static final Logger log = LoggerFactory.getLogger(MapTest.class);

    /**
     * N 个人抢 M 个红包问题。
     * 思路:
     * 为每个红包增加独特的锁 (避免不同的线程，在抢不同的红包时相互阻塞)
     *
     * putIfAbsent 的特点：将判断和赋值合成一个原子操作，即（若key不存在，则执行put操作，并返回null）。
     * 所以如果 putIfAbsent 返回了null, 说明put成功，即（抢到了红包）
     */
    @Test
    public void concurrentDemo() throws Exception {
        ConcurrentHashMap<String, Integer> redis = new ConcurrentHashMap<>();
        Set<String> keys = Sets.newHashSetWithExpectedSize(500);
        for (int j = 0; j < 50; ++j) {
            keys.add("id_" + j);
        }
        int concurrentCount = 1000;
        CountDownLatch beginCountDownLatch = new CountDownLatch(concurrentCount);

        Runnable runnable = () -> {
            beginCountDownLatch.countDown();
            try {
                beginCountDownLatch.await();
            } catch (InterruptedException e) {
                log.error("[await_error]msg={}", e.getMessage(), e);
            }
            for (String key : keys) {
                String name = Thread.currentThread().getName();
                int indexOf = name.indexOf("-");
                String indexStr = name.substring(indexOf + 1, name.length());
                Integer index = Integer.valueOf(indexStr);
                Integer oldValue = redis.putIfAbsent(key, index);
                if (null == oldValue) {
                    log.info("[Thread_name]:{} [Get_id]:{}", name, key);
                }
            }
        };
        for (int i = 0; i < concurrentCount; ++i) {
            Thread thread = new Thread(runnable);
            thread.setName("redis-" + i);
            thread.start();
        }

        log.info("[redis]={}", redis.values());
    }

}
