package com.nhfc99.template.Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleTest {
    private static final Logger logger = LoggerFactory.getLogger(SimpleTest.class);

    @Test
    public void doTest() {
        logger.info("测试信息");
    }

    @Test
    public void doTest1() {
        logger.info("测试信息1");
    }
}
