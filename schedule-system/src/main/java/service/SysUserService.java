package service;

import pojo.SysUser;

/**
 * @description: 该表格定义了以Sys_user表格为核心的业务处理
 * @author：xiaozheng
 * @date: 20
 */
public interface SysUserService {

    int regist(SysUser sysUser);

    SysUser findByUsername(String username);
}
