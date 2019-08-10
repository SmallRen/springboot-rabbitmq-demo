package com.smallren.entity;

import com.smallren.listener.EntityListener;

import javax.persistence.*;
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
@Entity
@Table(name = "USER")
@EntityListeners(value = {EntityListener.class})
public class User implements Serializable {
    private static final long serialVersionUID = 8544743457205193229L;

    private Long id;
    private String username;
    private String password;

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "USERNAME", unique = true, nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "PASSWORD", unique = true, nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
