package com.macro.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 应用启动入口
 * https://gitee.com/zscat-platform/mall on 2018/4/26.
 */
@SpringBootApplication
@MapperScan({"com.macro.mall.mapper", "com.macro.mall.mapper"})
@EnableTransactionManagement
//exclude表示自动配置时不包括Multipart配置
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
public class MallAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallAdminApplication.class, args);
    }
    /**
     * 显示声明CommonsMultipartResolver为mutipartResolver
     */
    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        //resolver.setDefaultEncoding("UTF-8");
        //resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
        resolver.setResolveLazily(true);
        resolver.setMaxInMemorySize(40960);
        resolver.setMaxUploadSize(20 * 1024 * 1024);//上传文件大小 3M 3*1024*1024
        return resolver;
    }
}
