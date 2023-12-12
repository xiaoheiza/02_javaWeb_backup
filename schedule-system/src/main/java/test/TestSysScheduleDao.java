package test;

import dao.SysScheduleDao;
import dao.impl.SysScheduleImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.SysSchedule;

import java.util.List;

/**
 * @description:
 * @author：xiaozheng
 * @date: 20
 */
public class TestSysScheduleDao {

    private static SysScheduleDao scheduleDao;

    @BeforeClass
    public static void initScheduleDao() {
        scheduleDao = new SysScheduleImpl();
    }

    @Test
    public void testSchedule() {
        int rows = scheduleDao.addSchedule(new SysSchedule(null, 2, "学习数据库", 1));
        System.out.println(rows);
    }
    @Test
    public void testScheduleAll() {
        List<SysSchedule> scheduleList = scheduleDao.findAll();
        scheduleList.forEach(System.out::println);
    }
}
