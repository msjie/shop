package cn.yusite.shop.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 个人信息服务.
 *
 * @author shijie
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BusinessProfileApplication {

    public static void main(String[] args) {

        SpringApplication.run(BusinessProfileApplication.class, args);
    }
}
