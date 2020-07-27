package com.zxl.test.provider1001.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p >
 *
 * @author zxl
 * @email xiaoliang.zhang@payby.com
 * @date TestController.java v1.0  2020/7/27 12:07 PM
 */
@RestController
public class TestController {

    @GetMapping("/health")
    public String health() throws InterruptedException {
        System.out.println("1001 in");
        System.out.println("1001 out");

        return "ok";
    }

    @GetMapping("/test")
    public String test() {
        return "test:1001";
    }
}
