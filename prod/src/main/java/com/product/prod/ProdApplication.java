package com.product.prod;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.product.prod.pojo.Prodotto;
import com.product.prod.pojo.Review;
import com.product.prod.serv.ProdottoService;
import com.product.prod.serv.ReviewService;

@SpringBootApplication
public class ProdApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProdApplication.class, args);
	}

	@Autowired
	private ProdottoService prodottoService;
	@Autowired
	private ReviewService reviewService;

	@Override
	public void run(String... args) throws Exception {

		Prodotto p1 = new Prodotto("Pasta", "Pasta alimentare", 1.5, 0, 10, "Nuovo");
		Prodotto p2 = new Prodotto("Latte", "Latte fresco intero", 2.0, 2, 5, "Usato");
		Prodotto p3 = new Prodotto("Pane", "Pane integrale", 1.2, 0, 8, "Nuovo");
		Prodotto p4 = new Prodotto("Frutta", "Frutta mista", 3.0, 0, 12, "Nuovo");
		Prodotto p5 = new Prodotto("Yogurt", "Yogurt magro alla frutta", 1.0, 1, 6, "Usato");

		prodottoService.save(p1);
		prodottoService.save(p2);
		prodottoService.save(p3);
		prodottoService.save(p4);
		prodottoService.save(p5);
		System.out.println("=========================================================================");

		Review r1 = new Review(5, "Perfect!", p1);
		Review r2 = new Review(1, "Horrible", p2);
		Review r3 = new Review(3, "Mid", p3);
		Review r4 = new Review(4, "Not bad", p3);

		reviewService.save(r1);
		reviewService.save(r2);
		reviewService.save(r3);
		reviewService.save(r4);

		System.out.println("=========================================================================");

		System.out.println("Find all");
		System.out.println(reviewService.findAll());

		System.out.println("Find by ID");

		// System.out.println(reviewService.findById(3));
		Optional<Review> opReview = reviewService.findById(3);

		if (opReview.isEmpty()) {
			System.out.println("Review is not present");
		} else {
			Review foundReview = opReview.get();
			System.out.println(foundReview);
		}


		

		System.out.println("Delete first and last");
		reviewService.delete(r1);
		reviewService.delete(r3);

		System.out.println(reviewService.findAll());

		System.out.println("Adding everything again");
		reviewService.save(r1);
		reviewService.save(r3);

		System.out.println("The end");
	}

	
}
