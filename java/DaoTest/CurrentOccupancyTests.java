package DaoTest;


import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.ltts.shadow.smartcafeteria.Dao.CurrentOccupancyDao;
import com.ltts.shadow.smartcafeteria.Models.CurrentOccupancy;

@DataJpaTest
@AutoConfigureTestDatabase
@Rollback(false)
public class CurrentOccupancyTests {
	

	@Autowired
	private CurrentOccupancyDao dao;
	
	@Test
	public  void testCreateCurrentOccupancy() {
	
		CurrentOccupancy count=new CurrentOccupancy();
		count.setId(2148);
		count.setCount(46);
		count.setDate(2021-05-14);
		
		CurrentOccupancy savedCurrentOccupancy= dao.save(count);
		
		assertThat(count.getId()).isEqualTo(count.getId());
	
	
           }
	  
}