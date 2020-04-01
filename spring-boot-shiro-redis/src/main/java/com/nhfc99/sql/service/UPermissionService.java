package com.nhfc99.sql.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhfc99.sql.dao.UPermissionDOMapper;
import com.nhfc99.sql.model.UPermissionDO;
import com.nhfc99.sql.model.URolePermissionDO;
import com.nhfc99.sql.model.UUserRole;

@Service
public class UPermissionService {
    @Autowired
    RolePermissionService rolePermissionService;

    @Autowired
    UUserRoleService uUserRoleService;

    @Autowired
    UPermissionDOMapper uPermissionDOMapper;

    public List<UPermissionDO> findPermissionByUid(Long uid) {
        List<UUserRole> userRoles = uUserRoleService.getRolesByUid(uid);
        List<UPermissionDO> list = new ArrayList<UPermissionDO>();
        for (int i = 0; i < userRoles.size(); i++) {
            UUserRole userRole = userRoles.get(i);
            List<URolePermissionDO> list2 = rolePermissionService.getRolePermissionsByRid(userRole.getRid());
            for (int j = 0; j < list2.size(); j++) {
                URolePermissionDO uRolePermissionDO = list2.get(j);
                UPermissionDO uPermissionDO = uPermissionDOMapper.selectByPrimaryKey(uRolePermissionDO.getPid());
                list.add(uPermissionDO);
            }
        }
        return list;
    }
}
