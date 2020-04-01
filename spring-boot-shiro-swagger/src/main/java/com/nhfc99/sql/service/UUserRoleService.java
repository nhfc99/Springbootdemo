package com.nhfc99.sql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhfc99.sql.dao.UUserRoleMapper;
import com.nhfc99.sql.model.UUserRole;

@Service
public class UUserRoleService {
    @Autowired
    UUserRoleMapper uUserRoleMapper;

    /**
     * 通过用户id获取角色id列表
     *
     * @param uid
     * @return
     */
    List<UUserRole> getRolesByUid(long uid) {
        return uUserRoleMapper.getUserRolesByUid(uid);
    }
}
