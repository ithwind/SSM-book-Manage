package config;


import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@MapperScan("dao")

public class MybatisConfig {
    //配置分页插件
    @Bean
    public PageInterceptor getPageInterceptor(){
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("value", "true");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;

    }


    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(@Autowired DataSource dataSource,
                                                       @Autowired PageInterceptor pageInterceptor){
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setConfigLocation(new ClassPathResource("mybatis.xml"));
        Interceptor[] plugins = {pageInterceptor};
        bean.setDataSource(dataSource);
        bean.setPlugins(plugins);
        return bean;
    }



}
