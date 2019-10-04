package cn.yusite.shop.provider.test;
import cn.yusite.shop.provider.domain.UmsAdmin;
import cn.yusite.shop.provider.mapper.UmsAdminMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class UmsAdminTest {

    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void testSelectAll() {

        List<UmsAdmin> umsAdmins = umsAdminMapper.selectAll();
        umsAdmins.forEach(umsAdmin -> {
            System.out.println(umsAdmin);
        });
    }

    @Test
    public void insert() {

        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setUsername("shijie");
        umsAdmin.setPassword(passwordEncoder.encode("123456"));
        umsAdmin.setIcon("");
        umsAdmin.setEmail("ligongdamao@163.com");
        umsAdmin.setNickName("");
        umsAdmin.setNote("");
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setLoginTime(new Date());
        umsAdmin.setStatus(0);
        int insert = umsAdminMapper.insert(umsAdmin);
        Assert.assertEquals(insert,1);
    }
}
