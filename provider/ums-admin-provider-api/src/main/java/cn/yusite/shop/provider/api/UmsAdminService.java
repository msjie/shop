package cn.yusite.shop.provider.api;

import cn.yusite.shop.provider.domain.UmsAdmin;

/**
 * @author shijie
 */
public interface UmsAdminService {

    /**
     * 新增用户
     * @param umsAdmin {@link UmsAdmin}
     * @return 大于0则表示注册成功
     */
    int insert(UmsAdmin umsAdmin);

    /**
     * 获取用户
     * @param username 用户名
     * @return {@link UmsAdmin}
     */
    UmsAdmin get(String username);

    /**
     * 获取用户
     * @param umsAdmin {@link UmsAdmin}
     * @return
     */
    UmsAdmin get(UmsAdmin umsAdmin);
}
