package com.smallren.service.impl;

import com.smallren.dao.UserRepository;
import com.smallren.entity.User;
import com.smallren.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: renbaojia
 * @CreateDate: 2019/8/8 10:56
 * @UpdateUser:
 * @UpdateDate: 2019/8/8 10:56
 * @UpdateRemark:
 * @Version: 3.5.xxx
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> select() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
