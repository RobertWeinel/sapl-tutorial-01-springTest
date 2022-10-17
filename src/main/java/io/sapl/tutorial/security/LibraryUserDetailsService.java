package io.sapl.tutorial.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.sapl.tutorial.domain.LibraryUser;

@Service
public class LibraryUserDetailsService implements UserDetailsService {

	Map<String, LibraryUser> users = new HashMap<>();

	public void load(LibraryUser user) {
		users.put(user.getUsername(), user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = users.get(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found");
		}
		return user;
	}

}