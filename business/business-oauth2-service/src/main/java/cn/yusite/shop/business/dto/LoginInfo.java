package cn.yusite.shop.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shijie
 */
@Data
public class LoginInfo implements Serializable {

    private String name;
    private String avatar;
}
