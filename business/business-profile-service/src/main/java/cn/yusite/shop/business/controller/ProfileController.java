package cn.yusite.shop.business.controller;

import cn.yusite.shop.business.dto.UmsAdminDto;
import cn.yusite.shop.common.dto.ResponseResult;
import cn.yusite.shop.provider.api.UmsAdminService;
import cn.yusite.shop.provider.domain.UmsAdmin;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shijie
 */
@RestController
@RequestMapping("profile")
public class ProfileController {

    @Reference(version = "1.0.0")
    private UmsAdminService umsAdminService;

    @GetMapping("info/{username}")
    public ResponseResult<UmsAdminDto> info(@PathVariable String username){

        UmsAdmin umsAdmin = umsAdminService.get(username);
        UmsAdminDto dto = new UmsAdminDto();
        BeanUtils.copyProperties(umsAdmin, dto);
        return new ResponseResult<UmsAdminDto>(ResponseResult.CodeStatus.OK, "获取个人信息", dto);
    }

}
