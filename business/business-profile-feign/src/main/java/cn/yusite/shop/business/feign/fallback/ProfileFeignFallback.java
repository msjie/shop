package cn.yusite.shop.business.feign.fallback;

import cn.yusite.shop.business.feign.ProfileFeign;
import cn.yusite.shop.common.dto.ResponseResult;
import cn.yusite.shop.common.utils.MapperUtils;
import org.springframework.stereotype.Component;

/**
 * 个人信息服务熔断
 *
 * @author shijie
 */
@Component
public class ProfileFeignFallback implements ProfileFeign {

    private static final String BREAKING_MESSAGE = "请求失败了，请检查您的网络";

    @Override
    public String info(String username) {

        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(ResponseResult.CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
