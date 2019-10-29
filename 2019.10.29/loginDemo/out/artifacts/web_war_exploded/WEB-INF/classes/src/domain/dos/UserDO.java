package domain.dos;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zbc
 * @version 1.0
 * @date 2019-10-27 11:21
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDO implements Serializable {
    private Integer id;
    private String name;
    private String passowrd;
    private String nickName;
    private Integer score;


}
