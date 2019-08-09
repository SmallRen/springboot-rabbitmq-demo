package com.smallren.dao;

import com.smallren.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: renbaojia
 * @CreateDate: 2019/8/8 10:59
 * @UpdateUser:
 * @UpdateDate: 2019/8/8 10:59
 * @UpdateRemark:
 * @Version: 3.5.xxx
 */
@Repository
public interface UserDao {
    List<User> select();

    int save(User user);
}
