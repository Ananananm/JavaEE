package domain.dos;

import lombok.*;

/**
 * @author zhangbenchao
 * @date 2019-10-29 12:19
 * 文件描述：
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDo {
    private int id;
    private int originalScore;
    private int violateScore;
    private int currentScore;
    private int userId;

}
