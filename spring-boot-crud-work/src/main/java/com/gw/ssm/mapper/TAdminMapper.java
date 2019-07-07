package com.gw.ssm.mapper;

import com.gw.ssm.bean.TAdmin;

import java.util.List;

public interface TAdminMapper {
    List<TAdmin> getAllAdmin();

    void insertSelective(TAdmin admin);

    void delUserById(Integer id);

    TAdmin getUserById(Integer id);

    void updateUserById(TAdmin admin);
}
