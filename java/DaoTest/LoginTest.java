package DaoTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.ltts.shadow.smartcafeteria.Dao.LoginDao;
import com.ltts.shadow.smartcafeteria.Models.Login;
import com.ltts.shadow.smartcafeteria.Models.User;

public class LoginTest {


	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private LoginDao repo;
	
	@Test
	public void testCreateUser() {
		Login user = new Login();
		user.setUsername("sa123");
		user.setPassword("sa123");
		
		Login savedUser = repo.save(user);
		
		
		assertThat(user.getUsername()).isEqualTo(user.getUsername());
		
	}
	
	@Test
	public void testFindByUsername() {
		String username = "sa123";
		Login user = repo.findByUsername(username);
		
		assertThat(user.getUsername()).isEqualTo(username);
	}
		
}

