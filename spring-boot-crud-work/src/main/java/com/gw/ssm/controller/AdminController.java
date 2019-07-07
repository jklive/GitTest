package com.gw.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gw.ssm.bean.TAdmin;
import com.gw.ssm.mapper.TAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    TAdminMapper adminMapper;

    //展示分页数据
    @GetMapping("/list")
    public String toCrudPage(@RequestParam(value="pn",defaultValue = "1")Integer pn,
                             @RequestParam(value="condition",defaultValue = "")String condition, Model model){

        PageHelper.startPage(pn, 5);

        List<TAdmin> admins = adminMapper.getAllAdmin();

        PageInfo<TAdmin> pageInfo = new PageInfo(admins, 5);

        model.addAttribute("admins",admins);
        model.addAttribute("pageInfo",pageInfo);

        return "list";
    }
}

