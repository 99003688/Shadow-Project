 package Services;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class customUserdetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		if (username.equals("user")) {

			return new User( "Saujanya", "Saujanya123" , new ArrayList<>() );
			
		}
		else {
			throw new UsernameNotFoundException("User not find");
		}
		
	}

}
