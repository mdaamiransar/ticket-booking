package com.ticketbooking.service;

/*import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ticketbooking.repository.UserRepository;

 
@Service
public class MyDBAuthenticationService implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepository;
 
    *//**
	 * Returns a populated {@link UserDetails} object. The username is first retrieved from 
	 * the database and then mapped to a {@link UserDetails} object.
	 *//*
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	com.ticketbooking.domain.User domainUser = userRepository.findByUsername(username);
        System.out.println("Account= " + domainUser);
 
        if (domainUser == null) {
            throw new UsernameNotFoundException("User " //
                    + username + " was not found in the database");
        }
 
        
 
        boolean enabled = true; //domainUser.isActive();
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
 
        UserDetails userDetails = (UserDetails) new User(
        		domainUser.getUsername(), //
                domainUser.getPassword(),
                enabled, 
                accountNonExpired, //
                credentialsNonExpired, 
                accountNonLocked, 
                getAuthorities(domainUser.getRole()));
 
        return userDetails;
    }
    
    public Collection<? extends GrantedAuthority> getAuthorities(String role) {
//		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
//		return authList;
    	
    	// EMPLOYEE,MANAGER,..
//        String role = domainUser.getRole();
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
 
        // ROLE_EMPLOYEE, ROLE_MANAGER
        GrantedAuthority authority = new SimpleGrantedAuthority(role);
 
        grantList.add(authority);
        
        return grantList;
	}
 
}
*/