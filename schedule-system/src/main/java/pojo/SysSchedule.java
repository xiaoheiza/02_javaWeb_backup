package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


 /**
 * 1、实体类的类名和表格名称应该对应
 * 2、实体类的属性名和表格的列名应该对应
 * 3、每个属性都必须是私有的
 * 4、每个属性都应该具备getter和setter
 * 5、必须具备无参构造器
 * 6、应该实现序列化接口（缓存 分布式项目数据传动 可能会将对象序列化）
 * 7、应该重写类的hashcode和equals方法
 * 8、toString是否重写都可以
 *
 *
 * 使用lombok帮助我们生成这些内容 getter setter 全参数构造 无参数构造 equals hashcode
 *  使用步骤
 *      1、检查idea是否安装了lombok插件
 *      2、检查是否勾选了enable annotation processer ( build,execution,deployment->annotation processors
 *      3、导入lombok的依赖在实体类上添加注解
 * */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysSchedule implements Serializable {
    private Integer sid;
    private Integer uid;
    private String title;
    private Integer completed;
}
