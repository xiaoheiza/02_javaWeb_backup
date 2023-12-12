package dao.impl;

import dao.BaseDao;
import dao.SysScheduleDao;
import pojo.SysSchedule;

import java.util.List;

/**
 * @description:
 * @author：xiaozheng
 * @date: 20
 */
public class SysScheduleImpl extends BaseDao implements SysScheduleDao {
    @Override
    public int addSchedule(SysSchedule schedule) {
        String sql = "insert into sys_schedule values(DEFAULT, ?, ?, ?)";
        int rows = baseUpdate(sql, schedule.getUid(), schedule.getTitle(), schedule.getCompleted());
        return rows;
    }

    @Override
    public List<SysSchedule> findAll() {
        String sql = "select sid, uid, title, completed from sys_schedule";
        List<SysSchedule> scheduleList = baseQuery(SysSchedule.class, sql);
        return scheduleList;
    }
}
