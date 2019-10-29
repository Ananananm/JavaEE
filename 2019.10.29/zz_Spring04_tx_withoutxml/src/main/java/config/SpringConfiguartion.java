package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhangbenchao
 * @date 2019-10-29 16:48
 * 文件描述：
 */
@Configuration
@ComponentScan("com.zz")
@Import({JdbcConfig.class,TransactionConfig.class})
@PropertySource("db.properties")
@EnableTransactionManagement
public class SpringConfiguartion {
}
