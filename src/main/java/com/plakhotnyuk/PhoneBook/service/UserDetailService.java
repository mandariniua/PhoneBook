package com.plakhotnyuk.PhoneBook.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.plakhotnyuk.PhoneBook.bean.User;
import com.plakhotnyuk.PhoneBook.bean.UserProfile;

@Service("userDetailsService")
public class UserDetailService implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
        User user = userService.findByUsername(ssoId);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (UserProfile userProfile : user.getUserProfiles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(userProfile.getType()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
		

}
