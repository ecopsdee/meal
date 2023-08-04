package com.dexdee.meal.Config;

import feign.RequestInterceptor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FoodShopAuth {

    @Value("${client.key}")
    private String key;

    @Bean
    public RequestInterceptor requestInterceptor(){
        return requestTemplate -> {
            requestTemplate.header("x-api-key", this.key );
        };
    }

}
