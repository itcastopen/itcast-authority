package com.itheima.authority.biz.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.authority.biz.dao.auth.UserGroupMapper;
import com.itheima.authority.biz.service.auth.UserGroupService;
import com.itheima.authority.entity.auth.UserGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户组
 * </p>
 */
@Slf4j
@Service
public class UserGroupServiceImpl extends ServiceImpl<UserGroupMapper, UserGroup> implements UserGroupService {

}
