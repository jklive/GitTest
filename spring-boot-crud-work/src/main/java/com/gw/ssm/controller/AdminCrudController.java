package com.gw.ssm.controller;

import com.gw.ssm.bean.TAdmin;
import com.gw.ssm.mapper.TAdminMapper;
import com.gw.ssm.util.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class AdminCrudController {

    @Autowired
    TAdminMapper adminMapper;

    //处理保存用户的请求
    @PostMapping("/user/add")
    public String addUser(TAdmin admin){

        admin.setUserpswd(AppUtils.getDigestPwd("123456"));
        admin.setCreatetime(AppUtils.getCurrentTimeStr());
        adminMapper.insertSelective(admin);
        return "redirect:/list?pn=" + Integer.MAX_VALUE;
    }


    //处理根据id删除用户的请求
    @GetMapping("/user/delete")
    public String delUser(Integer id,@RequestParam(value="pn",defaultValue = "1")Integer pn){
        adminMapper.delUserById(id);
        return "redirect:/list?pn=" + pn;
    }

    //处理根据id查询用户的请求（模态框回显用）
    @ResponseBody
    @GetMapping("/user/select")
    public TAdmin selectUserById(Integer id){
       TAdmin admin =  adminMapper.getUserById(id);

       return admin;
    }

    //处理修改用户的请求
    @PostMapping("/user/update")
    public String updateUser(TAdmin admin, @RequestParam(value="pn",defaultValue = "1")Integer pn){

        System.out.println(admin);
        adminMapper.updateUserById(admin);
        return "redirect:/list?pn=" + pn;
    }
}
