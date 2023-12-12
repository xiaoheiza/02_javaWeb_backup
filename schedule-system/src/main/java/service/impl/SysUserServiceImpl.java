package service.impl;

import dao.SysUserDao;
import dao.impl.SysUserDaoImpl;
import pojo.SysUser;
import service.SysUserService;
import util.MD5Util;

/**
 * @description:
 * @author：xiaozheng
 * @date: 20
 */
public class SysUserServiceImpl implements SysUserService {

    private SysUserDao userDao = new SysUserDaoImpl();

    @Override
    public int regist(SysUser sysUser) {
        // 将用户的明文密码转换为密文密码
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));
        // 调用DAO层的方法将SysUser存入数据库
        return userDao.addSysUser(sysUser);
    }

    @Override
    public SysUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
