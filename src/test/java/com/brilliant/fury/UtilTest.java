package com.brilliant.fury;


import com.brilliant.fury.http.HttpClient;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试
 */
public class UtilTest {

    private static final Logger log = LoggerFactory.getLogger(UtilTest.class);

    @Test
    public void httpClientTest() throws Exception {
        String resp = HttpClient.get("https://www.baidu.com/");
        log.info("resp:{}", resp);
    }

}
