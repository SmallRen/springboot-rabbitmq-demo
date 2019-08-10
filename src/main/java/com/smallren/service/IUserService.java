package com.smallren.service;

import com.smallren.entity.User;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: renbaojia
 * @CreateDate: 2019/8/8 10:55
 * @UpdateUser:
 * @UpdateDate: 2019/8/8 10:55
 * @UpdateRemark:
 * @Version: 3.5.xxx
 */
public interface IUserService {
    List<User> select();

    User save(User user);
}
