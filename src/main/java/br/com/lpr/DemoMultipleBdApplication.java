package br.com.lpr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(excl'ude={DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class})
//@ComponentScan(basePackages = {"br.com.lpr.read.repositories","br.com.lpr.write.repositories","br.com.lpr.services","br.com.lpr.config","br.com.lpr.write.config","br.com.lpr.read.config"})
//@EntityScan(basePackages = {"br.com.lpr.entities"})
//@EnableJpaRepositories(basePackages = {"br.com.lpr.repositories"})
public class DemoMultipleBdApplication{

	public static void main(String[] args) {
		SpringApplication.run(DemoMultipleBdApplication.class, args);
	}
	
//	@Bean
//	public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
//	   return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
//	}
	
//	@Bean(name="entityManagerFactory")
//	public LocalSessionFactoryBean sessionFactory() {
//	    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean(); 
//	    return sessionFactory;
//	}
	
	
}
