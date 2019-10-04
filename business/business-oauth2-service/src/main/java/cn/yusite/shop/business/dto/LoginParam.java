package cn.yusite.shop.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shijie
 */
@Data
public class LoginParam implements Serializable {

    private String username;
    private String password;
}
