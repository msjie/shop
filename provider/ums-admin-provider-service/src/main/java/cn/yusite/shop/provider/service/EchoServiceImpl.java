package cn.yusite.shop.provider.service;

import cn.yusite.shop.provider.api.EchoService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author shijie
 */
@Service(version = "1.0.0")
public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String str) {
        return "hello dubbo "+str;
    }
}
