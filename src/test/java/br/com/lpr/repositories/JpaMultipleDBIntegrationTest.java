package br.com.lpr.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import br.com.lpr.entities.products.Product;
import br.com.lpr.entities.user.User;
import br.com.lpr.repositories.products.ProductRepository;
import br.com.lpr.repositories.user.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
public class JpaMultipleDBIntegrationTest {
 
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional("userTransactionManager")
    @DisplayName("quando criar usuário e for sucesso")
    public void whenCreatingUser_thenCreated() {
        User user = new User();
        user.setName("John");
        user.setEmail("john@test.com");
        user.setAge(20);
        user = userRepository.save(user);

        assertNotNull(userRepository.findById(user.getId()));
    }

    @Test
    @Transactional("userTransactionManager")
    @DisplayName("quando criar usuário com um email ja existente e for fazer rolback")
    public void whenCreatingUsersWithSameEmail_thenRollback() {
        User user1 = new User();
        user1.setName("John");
        user1.setEmail("john@test.com");
        user1.setAge(20);
        user1 = userRepository.save(user1);
        assertNotNull(userRepository.findById(user1.getId()));

        User user2 = new User();
        user2.setName("Tom");
        user2.setEmail("john@test.com");
        user2.setAge(10);
        try {
            user2 = userRepository.save(user2);
        } catch (DataIntegrityViolationException e) {
        }

        assertNull(userRepository.findById(user2.getId()));
    }

    @Test
    @Transactional("productTransactionManager")
    @DisplayName("quando criar produto e for sucesso")
    public void whenCreatingProduct_thenCreated() {
        Product product = new Product();
        product.setName("Book");
        product.setId(2);
        product.setPrice(20);
        product = productRepository.save(product);

        assertNotNull(productRepository.findById(product.getId()));
    }
}