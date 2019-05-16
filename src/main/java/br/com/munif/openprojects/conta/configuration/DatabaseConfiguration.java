package br.com.munif.openprojects.conta.configuration;

import br.com.munif.framework.vicente.application.VicRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {
    "br.com.munif.openprojects.conta", 
    "br.com.munif.framework.vicente.application.victenancyfields", 
    "br.com.munif.framework.vicente.api.errors",
    "br.com.munif.framework.vicente.security"
})
@EnableAutoConfiguration()
@EntityScan(basePackages = {
    "br.com.munif.framework.vicente.domain", 
    "br.com.munif.openprojects.conta.domain",
    "br.com.munif.framework.vicente.security"
})
@EnableJpaRepositories(basePackages = {
    "br.com.munif.openprojects.conta.repository", 
    "br.com.munif.framework.vicente.application.victenancyfields",
    "br.com.munif.framework.vicente.security.repository"
}, repositoryBaseClass = VicRepositoryImpl.class)
@EnableTransactionManagement
public class DatabaseConfiguration {

}
