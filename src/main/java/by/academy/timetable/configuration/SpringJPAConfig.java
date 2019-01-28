package by.academy.timetable.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "by.academy.timetable.repository")
@EnableTransactionManagement
@PropertySource("classpath:app.properties")
public class SpringJPAConfig {
    
    @Autowired
    Environment env;
    
    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(env.getProperty("db.driverClassName"));
        ds.setUrl(env.getProperty("db.url"));
        ds.setUsername(env.getProperty("db.username"));
        ds.setPassword(env.getProperty("db.password"));
        return ds;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emFB = new LocalContainerEntityManagerFactoryBean();
        emFB.setPackagesToScan("by.academy.timetable");
        emFB.setDataSource(this.dataSource());
        
        HibernateJpaVendorAdapter jpaAdapter = new HibernateJpaVendorAdapter();
        jpaAdapter.setDatabasePlatform(env.getProperty("jpa.dialect"));
        jpaAdapter.setGenerateDdl(Boolean.parseBoolean(env.getProperty("generateDDL")));
        jpaAdapter.setShowSql(Boolean.parseBoolean(env.getProperty("showSQL")));
        
        emFB.setJpaVendorAdapter(jpaAdapter);
        return emFB;
    }
    
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
