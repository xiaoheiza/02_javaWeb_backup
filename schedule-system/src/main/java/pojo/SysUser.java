package pojo;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;



@AllArgsConstructor     // 全参构造
@NoArgsConstructor      // 无参构造
@Data                   // 相当于getter setter hashcode equals tostring
public class SysUser implements Serializable {
    private Integer uid;
    private String username;
    private String userPwd;
}
