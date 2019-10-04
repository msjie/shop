package cn.yusite.shop.business.feign;

import cn.yusite.shop.business.feign.fallback.ProfileFeignFallback;
import cn.yusite.shop.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author shijie
 */
@FeignClient(value = "business-profile",path = "profile",
        configuration = FeignRequestConfiguration.class,
        fallback = ProfileFeignFallback.class)
public interface ProfileFeign {

    /**
     * 获取个人信息
     *
     * @param username {@code String} 用户名
     * @return {@code String} JSON
     */
    @GetMapping(value = "info/{username}")
    String info(@PathVariable String username);


}
