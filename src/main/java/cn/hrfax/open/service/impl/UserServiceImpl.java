package cn.hrfax.open.service.impl;

import cn.hrfax.open.mapper.UserMapper;
import cn.hrfax.open.model.UserPo;
import cn.hrfax.open.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserPo> list() {
        return userMapper.selectList();
    }
}
