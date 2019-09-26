package com.codeup.silverlining.Repo;

import com.codeup.silverlining.Model.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Long> {
    Iterable<Review> findAllByuser_id(long id);
}
