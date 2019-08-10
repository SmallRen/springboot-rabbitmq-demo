package com.smallren.entity;

import java.io.Serializable;

/**
 * @Description: java类作用描述
 * @Author: renbaojia
 * @CreateDate: 2019/8/8 10:57
 * @UpdateUser:
 * @UpdateDate: 2019/8/8 10:57
 * @UpdateRemark:
 * @Version: 3.5.xxx
 */

public class User implements Serializable {
    private Long id;
    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
