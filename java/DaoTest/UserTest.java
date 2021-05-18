package DaoTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import com.fasterxml.jackson.annotation.JsonTypeInfo.None;
import com.ltts.shadow.smartcafeteria.SmartCafeteriaApplication;
import com.ltts.shadow.smartcafeteria.Dao.UserDao;
import com.ltts.shadow.smartcafeteria.Models.User;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@DataJpaTest
@AutoConfigureTestDatabase
@Rollback(false)
public class UserTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired (required=true)
	private UserDao repo;
	
	@Autowired(required=true)
	private User users;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setFullname("saujanya tailanng");
		user.setCompany("ltts");
		user.setDesignation("associate engineer");
		user.setUsername("sa123");
		user.setPassword("sa123");
		
		User savedUser = repo.save(user);
		
		
		assertThat(user.getUsername()).isEqualTo(user.getUsername());
		
	}
	
	@Test
	public void testFindByUsername() {
		String username = "sa123";
		User user = repo.findByUsername(username);
		
		assertThat(user.getUsername()).isEqualTo(username);
	}
		
}
