package com.codeup.silverlining.Repo;

import com.codeup.silverlining.Model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {
    Iterable<Post> findAllByuser_id(long id);

}
