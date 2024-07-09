package com.product.prod.serv;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.prod.pojo.Review;
import com.product.prod.repo.ReviewRepo;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    public List<Review> findAll() {
        
        return reviewRepo.findAll();
    }

    public Optional<Review> findById(int id) {

        return reviewRepo.findById(id);
    }

    public void save (Review review) {

        reviewRepo.save(review);
    }

    public void delete (Review review) {
        
        reviewRepo.delete(review);
    }
}
