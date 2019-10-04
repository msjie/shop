package cn.yusite.shop.business.controller;

import cn.yusite.shop.common.dto.ResponseResult;
import cn.yusite.shop.provider.api.UmsAdminService;
import cn.yusite.shop.provider.domain.UmsAdmin;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户注册.
 *
 * @author shijie
 */
@RestController
@RequestMapping("reg")
public class RegController {

    @Reference(version = "1.0.0")
    UmsAdminService umsAdminService;

    /**
     * 注册
     *
     * @param umsAdmin {@link UmsAdmin}
     * @return {@link ResponseResult}
     */
    @PostMapping
    public ResponseResult<UmsAdmin> reg(@RequestBody UmsAdmin umsAdmin) {

        //表单验证，（使用hibernate bean validate简化验证过程）
        String message = validateReg(umsAdmin);
        //通过验证
        if (StringUtils.isEmpty(message)) {
            int insert = umsAdminService.insert(umsAdmin);
            UmsAdmin admin = umsAdminService.get(umsAdmin.getUsername());
            //注册成功
            if (insert > 0) {
                return new ResponseResult<UmsAdmin>(HttpStatus.OK.value(), message, admin);
            }
        }
        return new ResponseResult<UmsAdmin>(HttpStatus.NOT_ACCEPTABLE.value(), message != null ? message : "用户注册失败");
    }

    /**
     * 注册信息验证.
     *
     * @param umsAdmin {@link UmsAdmin}
     * @return 验证结果
     */
    private String validateReg(UmsAdmin umsAdmin) {

        UmsAdmin admin = umsAdminService.get(umsAdmin.getUsername());
        if (admin != null) {
            return "用户名已存在，请重新输入";
        }
        return null;
    }

    ;


}
