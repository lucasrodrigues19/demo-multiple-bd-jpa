package br.com.lpr.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.util.CollectionUtils;

import br.com.lpr.entities.User;
import br.com.lpr.services.UserReadService;
import br.com.lpr.services.UserWriteService;

@Profile("test")
@Configuration
public class ConfigTest implements CommandLineRunner{

	@Autowired
	private UserWriteService userWriteService;
	
	@Autowired
	private UserReadService userReadService;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			User user = saveUser_ReturnUser_WhenSuccess();
			if(user != null)
				System.out.println("Id user: "+user.getId());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		List<User> listUser = userReadService.findAll();
		if(!CollectionUtils.isEmpty(listUser))
			System.out.println("Tem "+listUser.size()+" Usuarios!");
		else
			System.out.println("Não tem usuários");
		
		try {
			 User user2 = saveUser_ErrorRead();
			 System.out.println("Era para dar erro :(");
		}catch(Exception e) {
			System.out.println("Deu ruim em, foi salvar no readonly");
			e.printStackTrace();
		}
		
	}

		

	    public User saveUser_ReturnUser_WhenSuccess() {
	    	 User user1 = new User();
	         user1.setName("John");
	         user1.setEmail("john13@test.com");
	         user1.setAge(20);
	         return userWriteService.save(user1);
	    }
	    
	    public User saveUser_ErrorRead() {
	    	 User user1 = new User();
	         user1.setName("John");
	         user1.setEmail("john13@test.com");
	         user1.setAge(20);
	         return userReadService.save(user1);
	    }
}
