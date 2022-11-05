package com.bjpowernode.resttemplate;

import com.bjpowernode.resttemplate.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class RestTemplateApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testGetObject() {
        RestTemplate template = new RestTemplate();
        String url = "http://localhost:8080/testGet?name=ljn";
        String res = template.getForObject(url, String.class);
        System.out.println(res);
    }

    @Test
    void testGetEntity() {
        RestTemplate template = new RestTemplate();
        String url = "http://localhost:8080/testGet?name=ljn";
        ResponseEntity<String> res = template.getForEntity(url, String.class);
        System.out.println(res);
    }

    @Test
    void testPost1() {
        RestTemplate template = new RestTemplate();
        String url = "http://localhost:8080/testPost1";
        User user = new User("ljn", 25, 10000D);
        String res = template.postForObject(url, user, String.class);
        System.out.println(res);
    }

    @Test
    void testPost2() {
        RestTemplate template = new RestTemplate();
        String url = "http://localhost:8080/testPost2";
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap();
        map.add("name", "ljn");
        map.add("age", 26);
        map.add("salary", 10001D);
        ResponseEntity<String> res = template.postForEntity(url, map, String.class);
        System.out.println(res);
    }

}
