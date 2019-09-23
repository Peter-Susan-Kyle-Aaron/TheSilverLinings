package com.codeup.silverlining.Services;

import com.codeup.silverlining.Model.User;
import com.codeup.silverlining.Model.UserWithRole;
import com.codeup.silverlining.Repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailLoader implements UserDetailsService {
    private final UserRepo users;

    public UserDetailLoader(UserRepo users){
        this.users = users;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        return new UserWithRole(user);
    }
}