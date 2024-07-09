package com.product.prod.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.prod.pojo.Prodotto;

@Repository
public interface ProdottoRepo extends JpaRepository<Prodotto,Integer> {

}
