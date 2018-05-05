package com.xuebusi.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xuebusi.common.cache.InitDataCacheMap;
import com.xuebusi.entity.User;
import com.xuebusi.service.UserService;

/**
 * 用户基础信息
 * Created by SYJ on 2017/10/15.
 */
@Service
public class UserServiceImpl implements UserService {

	// @Autowired
	// private UserRepository userRepository;

    @Override
    public User findOne(Integer id) {
        Collection<User> users = InitDataCacheMap.getUserCacheMap().values();
        for (User user : users) {
            if (id == user.getId()) {
                return user;
            }
        }
		return new User();
    }

    @Override
    public List<User> findAll() {
        Collection<User> users = InitDataCacheMap.getUserCacheMap().values();
        if (users != null && users.size() > 0) {
            return (List<User>) users;
        }
		return new ArrayList<User>();
    }

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {
        User user = InitDataCacheMap.getUserCacheMap().get(username);
        if (user != null) {
            return user;
        }
		return new User();
    }

    /**
     * 保存个人设置
     * @param user
     * @return
     */
    @Override
    public User save(User user) {
		// User newUser = userRepository.save(user);
		// InitDataCacheMap.getUserCacheMap().put(newUser.getUsername(), newUser);
		return user;
    }
}
