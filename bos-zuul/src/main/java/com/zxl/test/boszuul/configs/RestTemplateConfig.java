package com.zxl.test.boszuul.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p></p >
 *
 * @author zxl
 * @email xiaoliang.zhang@payby.com
 * @date MainConfig.java v1.0  2020/7/23 10:32 AM
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
