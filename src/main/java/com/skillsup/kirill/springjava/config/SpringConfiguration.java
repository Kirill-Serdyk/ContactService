package com.skillsup.kirill.springjava.config;

import com.skillsup.kirill.springjava.service.ContactDao;
import com.skillsup.kirill.springjava.service.ContactFactory;
import com.skillsup.kirill.springjava.service.ContactServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Kirill on 18.12.2015.
 */

@Configuration
public class SpringConfiguration {

    @Bean
    public ContactDao contactDao(){
        return new ContactDao();
    }

    @Bean
    public ContactServiceImp contactServiceImp(){
        return new ContactServiceImp();
    }

    @Bean
    public ContactFactory contactFactory(){
        return new ContactFactory();
    }
}
