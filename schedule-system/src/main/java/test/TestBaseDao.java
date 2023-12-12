package test;

import dao.BaseDao;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.SysUser;

import java.util.List;

/**
 * @description:
 * @author：xiaozheng
 * @date: 20
 */
public class TestBaseDao {
    private static BaseDao baseDao;

    @BeforeClass
    public static void initBaseDao() {
        baseDao = new BaseDao();
    }

    @Test
    public void testBaseQueryObject() {
        String sql = "select count(1) from sys_user";       // 查询结果集是单行单列的一个值的数据方法
        Long count = baseDao.baseQueryObject(Long.class, sql);
        System.out.println(count);
    }

    @Test
    public void testBaseQuery() {
        String sql = "select uid, username, user_pwd userPwd from sys_user";
        List<SysUser> sysUserList = baseDao.baseQuery(SysUser.class, sql);
        sysUserList.forEach(System.out::println);
    }

    @Test
    public void testBaseUpdate() {
        String sql = "insert into sys_schedule values(DEFAULT, ?, ?, ?)";
        int rows = baseDao.baseUpdate(sql, 1, "学习java", 0);
        System.out.println(rows);
    }

    @Test
    public void testBaseUpdate2() {
        String sql = "insert into sys_user values(DEFAULT, ?, ?)";
        int rows = baseDao.baseUpdate(sql, "zhangsan2", "e10adc3949ba59abbe56e057f20f883e");
        System.out.println(rows);
    }
}
