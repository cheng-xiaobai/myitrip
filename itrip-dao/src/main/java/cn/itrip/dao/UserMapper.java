package cn.itrip.dao;

import cn.itrip.beans.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * 用户数据访问接口
 */
public interface UserMapper {
    /**
     * 根据参数查询分页用户
     * @return
     */
    List<User> getUsersByParams(Map<String , Object> params);

    /**
     * 根据条件查询勇哥个数
     * @param params
     * @return
     */
    int getUserCountByParams(Map<String , Object> params);
}
