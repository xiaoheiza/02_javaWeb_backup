package dao;

import pojo.SysUser;

/**
 *
 */
public interface SysUserDao {

    /**
     * 向数据库中增加一条用户记录的方法
     * @param sysUser
     * @return  增加成功返回1 失败返回0
     */
    int addSysUser(SysUser sysUser);

    SysUser findByUsername(String username);
}
