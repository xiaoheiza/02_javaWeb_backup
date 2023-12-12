package dao;

import pojo.SysSchedule;

import java.util.List;

/**
 * Data access Object 数据访问对象
 * 该类中用于定义针对表格的CRUD的方法
 * Dao层一般需要定义接口和实现类
 */
public interface SysScheduleDao {

    /**
     * 用于向数据库中添加一条日程记录
     * @param schedule 日程数据以SysSchedule实体类对象形式入参
     * @return  增加成功返回影响数据库记录的行数，行数为0说明增加失败，行数大于0说明增加成功
     */
    int addSchedule(SysSchedule schedule);

    /**
     * 查询用户的所用日程
     * @return 将所有日程放入一个List<SysSchdule>集合返回
     */
    List<SysSchedule> findAll();
}
