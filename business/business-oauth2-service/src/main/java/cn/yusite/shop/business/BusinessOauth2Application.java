package cn.yusite.shop.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 认证服务.
 * @author shijie
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BusinessOauth2Application {

    public static void main(String[] args) {

        SpringApplication.run(BusinessOauth2Application.class, args);
    }
}
