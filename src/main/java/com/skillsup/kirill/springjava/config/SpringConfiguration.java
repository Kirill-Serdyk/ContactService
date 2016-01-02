package com.skillsup.kirill.springjava.config;

import com.skillsup.kirill.springjava.dao.ContactDao;
import com.skillsup.kirill.springjava.service.impl.ContactServiceImp;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Kirill on 18.12.2015.
 */

@Configuration
@ComponentScan({"com.skillsup.kirill.springjava.service", "com.skillsup.kirill.springjava.dao"})
@EnableTransactionManagement
public class SpringConfiguration {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/contact_service");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }

//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:~/H2DB/Contacts");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("");
//
//        return dataSource;
//    }

//    @Bean
//    public DataSource dataSource() {
//        EmbeddedDatabaseBuilder edb = new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.HSQL);//.H2 or .DERBY
//        //.addScript("db/sql/create-db.sql")
//        //.addScript("db/sql/insert-data.sql")
//
//        DataSource dS = edb.build();
//        return dS;
//    }

    @Bean
    //@DependsOn("dataSource")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        em.setDataSource(dataSource());
        em.setPackagesToScan("com.skillsup.kirill.springjava.entity");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(additionalProperties());

        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    private Properties additionalProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");

        return properties;
    }

    @Bean
    public ContactDao contactDao(){
        return new ContactDao();
    }

    @Bean
    public ContactServiceImp contactServiceImp(){
        return new ContactServiceImp();
    }

//    @Bean
//    public ContactFactory contactFactory(){
//        return new ContactFactory();
//    }

}