package cn.yusite.shop.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author shijie
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.yusite.shop.provider.mapper")
public class UmsAdminProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UmsAdminProviderApplication.class,args);
    }
}
