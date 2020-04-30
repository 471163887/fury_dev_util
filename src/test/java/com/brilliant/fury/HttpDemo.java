package com.brilliant.fury;

import com.alibaba.fastjson.JSONObject;
import com.brilliant.fury.http.HttpClient;
import com.brilliant.fury.http.HttpResponse;
import com.google.common.collect.Maps;
import java.util.Map;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试
 */
public class HttpDemo {

    private static final Logger log = LoggerFactory.getLogger(HttpDemo.class);

    @Test
    public void hederDemo() throws Exception {
        Map<String, String> headers = Maps.newHashMap();
        headers.put("Authorization", "f04190d045e330da730dd6bba9eb099fa4d655ee");
        headers.put("Content-Type", "application/json");

        Map<String, String> params = Maps.newHashMap();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key", "test12345");
        jsonObject.put("value", "test1235_new_value");
        jsonObject.put("dataChangeCreatedBy", "fulingtong");
        String json = jsonObject.toJSONString();
        HttpResponse resp = HttpClient.postJson("https://zzconf.zhuanspirit" +
            ".com/openapi/v1/envs/uat/apps/222414/clusters/default/namespaces/application" +
            "/items", json, headers);
        log.info("resp:{}", resp.toString());
    }

}
