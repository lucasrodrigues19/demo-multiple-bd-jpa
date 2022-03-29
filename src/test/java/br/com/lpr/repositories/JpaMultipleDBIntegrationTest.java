package br.com.lpr.repositories;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import br.com.lpr.entities.User;
import br.com.lpr.read.repositories.UserReadRepository;
import br.com.lpr.write.repositories.UserWriteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
public class JpaMultipleDBIntegrationTest {
    
	@Autowired
    private UserWriteRepository userWriteRepository;
	
	@Autowired
    private UserReadRepository userReadRepository;
    
    @Test
    @DisplayName("save. Ao criar um usuario, Retorna o usuario, quando for sucesso")
    @Transactional("writePlatformTransactionManager")
    public void saveUser_ReturnUser_WhenSuccess() {
    	 User user1 = new User();
         user1.setName("John");
         user1.setEmail("john14@test.com");
         user1.setAge(20);
         user1 = userWriteRepository.save(user1);
         assertNotNull(user1.getId());
    }
    
    
    @Test
    @Transactional("readPlatformTransactionManager")
    @DisplayName("findAll. Listar todos os usuarios, quando for sucesso")
	public void findAll_ReturnAllUser_WhenSuccess() {
		 userReadRepository.findAll();
		 assertNotNull(userReadRepository.findAll());
	 }
    
    @Test
    @Transactional("readPlatformTransactionManager")
    @DisplayName("deleteById. Da erro, quando for no readonly")
	public void deleteById_ThrowException_WhenReadOnly() {
		Assertions.assertThatExceptionOfType(Exception.class)
		.isThrownBy(() -> userReadRepository.deleteById(20));
				 
    }
    
    
    @Test
    @DisplayName("save. Da erro, quando for no readonly")
    @Transactional("readPlatformTransactionManager")
    public void saveUser_ThrowException_WhenReadOnly() {
    	 User user1 = new User();
         user1.setName("John");
         user1.setEmail("john_salvar@test.com");
         user1.setAge(20);
         Assertions.assertThatExceptionOfType(JpaSystemException.class)
 		.isThrownBy(() ->userReadRepository.save(user1));
    }
    
//    @Bean
//	public UserWriteRepository getUserWriteRepository(IUserRepository userRepository) {
//		return new UserWriteRepository(userRepository);
//	}
}