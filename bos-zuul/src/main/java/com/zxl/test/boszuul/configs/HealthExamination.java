package com.zxl.test.boszuul.configs;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

import lombok.extern.slf4j.Slf4j;

/**
 * <p></p >
 *
 * @author zxl
 * @email xiaoliang.zhang@payby.com
 * @date HealthExamination.java v1.0  2020/7/23 10:45 AM
 */
@Component
@Slf4j
public class HealthExamination implements IPing{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public boolean isAlive(Server server) {
        String url = "http://" + server.getId() + "/health";
        try {
            ResponseEntity<String> health = restTemplate.getForEntity(url, String.class);
            if (health.getStatusCode() == HttpStatus.OK) {
                System.out.println(new Date() + "|||get " + url + "success and response is " + health.getBody());
                return true;
            }

            System.out.println("get " + url + "error and response is " + health.getBody());
            return false;
        } catch (Exception e) {
            System.out.println("get " + url + " failed");
            return false;
        }
    }
}
