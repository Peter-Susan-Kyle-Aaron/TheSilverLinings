package com.codeup.silverlining.Repo;

import com.codeup.silverlining.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User findById(long id);
    User findByUsername(String username);
}
