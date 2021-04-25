package config.copy;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import Services.customUserdetailsService;
import helper.jwtUtil;

@Component
public class jwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private jwtUtil jwtUtil;
	@Autowired
	private customUserdetailsService customerUserdetailsService;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		String requestTokenheader=request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		
		if (requestTokenheader!= null && requestTokenheader.startsWith("Bearer"))
		{
			
			jwtToken=requestTokenheader.substring(7);
			try {
				username=this.jwtUtil.getUsernameFromToken(jwtToken);
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			UserDetails userDetails= this.customerUserdetailsService.loadUserByUsername(username);
			//security
			if(username!= null && SecurityContextHolder.getContext().getAuthentication()==null) {
				
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
			else {
				System.out.println("token is not available");
			}
			
			
		}
		
		filterChain.doFilter(request, response);
		
		
		
	}

}
