package com.product.prod.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.prod.pojo.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review,Integer> {

}
