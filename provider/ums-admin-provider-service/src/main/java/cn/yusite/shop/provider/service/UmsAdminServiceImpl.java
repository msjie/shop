package cn.yusite.shop.provider.service;

import cn.yusite.shop.provider.api.UmsAdminService;
import cn.yusite.shop.provider.domain.UmsAdmin;
import cn.yusite.shop.provider.mapper.UmsAdminMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author shijie
 */
@Service(version = "1.0.0")
public class UmsAdminServiceImpl implements UmsAdminService {

    @Resource
    private UmsAdminMapper umsAdminMapper;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public int insert(UmsAdmin umsAdmin) {

        //初始化用户对象
        initUmsAdmin(umsAdmin);
        return umsAdminMapper.insert(umsAdmin);
    }

    @Override
    public UmsAdmin get(String username) {

        Example example = new Example(UmsAdmin.class);
        example.createCriteria().andEqualTo("username",username);
        return umsAdminMapper.selectOneByExample(example);
    }

    @Override
    public UmsAdmin get(UmsAdmin umsAdmin) {
        return umsAdminMapper.selectOne(umsAdmin);
    }

    /**
     * 初始化用户对象
     * @param umsAdmin {@link UmsAdmin}
     */
    private void initUmsAdmin(UmsAdmin umsAdmin){

        umsAdmin.setCreateTime(new Date());
        umsAdmin.setLoginTime(new Date());
        if(umsAdmin.getStatus() == null){
            umsAdmin.setStatus(0);
        }
        umsAdmin.setPassword(passwordEncoder.encode(umsAdmin.getPassword()));
    }
}
