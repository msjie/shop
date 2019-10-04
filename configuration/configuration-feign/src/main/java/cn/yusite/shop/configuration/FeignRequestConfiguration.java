package cn.yusite.shop.configuration;

import cn.yusite.shop.interceptor.FeignRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author shijie
 */
@Configuration
public class FeignRequestConfiguration {

    /**
     * 注入feign拦截器
     * @return {@link FeignRequestInterceptor}
     */
    @Bean
    public RequestInterceptor requestInterceptor(){

        return new FeignRequestInterceptor();
    }
}
