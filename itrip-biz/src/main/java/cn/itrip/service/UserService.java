package cn.itrip.service;

import cn.itrip.beans.pojo.User;
import cn.itrip.common.Page;

/**
 * 用户的业务逻辑接口
 */
public interface UserService {
    /**
     * 获取分页的用户
     * @return
     */
    Page<User> getPagedUsers(int pageIndex,String userName);
}
