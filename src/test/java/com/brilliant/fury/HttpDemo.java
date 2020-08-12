package com.brilliant.fury;

import com.alibaba.fastjson.JSONObject;
import com.brilliant.fury.http.HttpClient;
import com.brilliant.fury.http.HttpResponse;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试
 */
public class HttpDemo {

    private static final Logger log = LoggerFactory.getLogger(HttpDemo.class);



    @Test
    public void test1() {
        String str1 = "ab";
        String str2 = "ab";
        log.info("(str1==str2)={},str1.hashCode={},str2.hashCode={}", (str1 == str2), str1.hashCode(),
            str2.hashCode());

        String str3 = "ab";
        String str4 = "a" + "b";
        log.info("(str3==str4)={},str3.hashCode={},str4.hashCode={}", (str3 == str4), str3.hashCode(),
            str4.hashCode());

        String a = "a", b = "b";
        String str5 = "ab";
        String str6 = "a" + b;
        log.info("(str5==str6)={},str5.hashCode={},str6.hashCode={}", (str5 == str6), str5.hashCode(),
            str6.hashCode());
    }

    @Test
    public void headerDemo() throws Exception {
        Map<String, String> headers = Maps.newHashMap();
        headers.put("Authorization", "");
        headers.put("Content-Type", "application/json");

        Map<String, String> params = Maps.newHashMap();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key", "");
        jsonObject.put("value", "");
        jsonObject.put("dataChangeCreatedBy", "");
        String json = jsonObject.toJSONString();
        HttpResponse resp = HttpClient.postJson("", json, headers);
        log.info("resp:{}", resp.toString());
    }

    static int count = 0;

    @Test
    public void testoadNull() {
        LoadingCache<String, String> stringCache = CacheBuilder.newBuilder()
            .maximumSize(10)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String s) throws Exception {
                    System.out.println("xx");
                    ++count;
                    if (s.equals("hello")) {
                        return "world";
                    } else {
                        if (count == 3) {
                            return "ok";
                        } else {
                            return null;
                        }
                    }
                }
            });

        try {
            System.out.println(stringCache.get("hello"));
            // get触发load，load返回null则抛出异常：
            // com.google.common.cache.CacheLoader$InvalidCacheLoadException: CacheLoader
            // returned null for key other_key.
            String other_key = stringCache.get("other_key");
            System.out.println(other_key);
        } catch (Exception e) {
            log.error("", e);
        }

        try {
            String other_key = stringCache.get("other_key");
            System.out.println(other_key);
        } catch (Exception e) {
            log.error("", e);
        }

        try {
            String other_key = stringCache.get("other_key");
            System.out.println(other_key);
        } catch (Exception e) {
            log.error("", e);
        }
    }

    @Test
    public void limitTest() {
    }

}
