package com.zxl.test.boszuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * <p></p >
 *
 * @author zxl
 * @email xiaoliang.zhang@payby.com
 * @date TestZuulApplication.java v1.0  2020/7/27 11:16 AM
 */
@SpringBootApplication
@EnableZuulProxy
public class BosZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(BosZuulApplication.class, args);
    }
}
