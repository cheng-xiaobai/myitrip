package cn.itrip.controller;

import cn.itrip.beans.dto.Dto;
import cn.itrip.beans.pojo.User;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.Page;
import cn.itrip.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * biz的控制器
 */
@RestController   //--全部的方法都不要写@ResponseBody，都默认的使用ResponseBody
public class BizController {

    @Resource
    UserService userService;

    @RequestMapping("/display")
    @ResponseBody
    public Dto display(
            @RequestParam(value="page",defaultValue = "1",required = true) int pageIndex,
            @RequestParam(value="name",required = false) String userName){

        //查询分页的用户信息
        Page<User> pagedUsers = userService.getPagedUsers(pageIndex, userName);

        //返回的类
        Dto dto = DtoUtil.returnDataSuccess(pagedUsers);
        return dto;
    }


}
