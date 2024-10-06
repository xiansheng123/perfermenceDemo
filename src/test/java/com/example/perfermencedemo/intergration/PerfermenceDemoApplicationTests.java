package com.example.perfermencedemo.intergration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PerfermenceDemoApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Value("${test.name}")
    private String testName;

    @Test
    public void test1() {
        String url = "http://localhost:" + port + "/demo";
        String aa = this.testRestTemplate.getForObject(url, String.class);
        System.out.println(aa);
    }

    @Test
    public void test2() {
        System.out.println(testName);

    }


}
