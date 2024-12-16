package com.bitspark.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Datetime: 2024年12月16日22:02
 * @Author: Camellia.xiaohua/Bitspark
 * @Package: com.bitspark.config
 * @Project: BitSpark-Share-Backend
 * @Description: 全局跨域配置
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路径(覆盖所有请求)
        registry.addMapping("/**")
                //允许发送Cookie
                .allowCredentials(true)
                // 设置允许跨域请求的域名(必须使用patterns，否则*会和allowCredentials冲突)
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .maxAge(3600)
                .allowedHeaders("*")
                .exposedHeaders("*");
    }
}
