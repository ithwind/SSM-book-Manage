package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
/*
将MyBatisConfig类和JdbcConfig类交给Spring管理
 */
@Configuration
@Import({MybatisConfig.class, DatabaseConfig.class})
@ComponentScan("service")
@EnableTransactionManagement
public class SpringConfig {
    //事务管理器
    @Bean("transactionManager")
    public DataSourceTransactionManager getDataSourceTxManager(@Autowired DataSource dataSource){
        DataSourceTransactionManager dtm = new DataSourceTransactionManager();
        dtm.setDataSource(dataSource);
        return dtm;
    }
}






