package cn.itrip.service.impl;

import cn.itrip.beans.pojo.User;
import cn.itrip.common.Page;
import cn.itrip.dao.UserMapper;
import cn.itrip.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public Page<User> getPagedUsers(int pageIndex, String userName) {
        //页大小
        int pageSize = 5;
        //封装参数
        Map<String ,Object> params = new HashMap<>();
        params.put("userName",userName);  //----这里的Key要和dao层的if参数相同
        params.put("from",(pageIndex - 1)*pageSize);
        params.put("limit",pageSize);

        //查询每页的用户集合
        List<User> users = userMapper.getUsersByParams(params);
        //根据条件查询所有用户个数
        int totalCount = userMapper.getUserCountByParams(params);
        //封装数据
        Page<User> pagedUsers = new Page<>(pageIndex,pageSize,totalCount,users);

        return pagedUsers;
    }
}
