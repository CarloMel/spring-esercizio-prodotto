package com.product.prod.serv;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.prod.pojo.Prodotto;
import com.product.prod.repo.ProdottoRepo;

@Service
public class ProdottoService {

    @Autowired
    private ProdottoRepo prodottoRepo;

    public List<Prodotto> findAll() {

        return prodottoRepo.findAll();
    }

    public Optional<Prodotto> find(int id) {

        return prodottoRepo.findById(id);
    }

    public void save(Prodotto prodotto) {

        prodottoRepo.save(prodotto);
    }

    public void delete(Prodotto prodotto) {

        prodottoRepo.delete(prodotto);
    }

    public Prodotto getMaxPrice() {

        List<Prodotto> products = findAll();

        if (products == null || products.isEmpty()) {
            return null;
        }

        double max_price = Double.MIN_VALUE;
        Prodotto maxPriceProduct = null;

        for (Prodotto prod : products) {

            if (prod.getFinalPrice() > max_price) {

                max_price = prod.getFinalPrice();
                maxPriceProduct = prod;
            }
        }
        return maxPriceProduct;
    }

    public Prodotto getMinPrice() {

        List<Prodotto> products = findAll();

        if (products == null || products.isEmpty()) {
            return null;
        }

        double min_price = Double.MAX_VALUE;
        Prodotto minPriceProduct = null;

        for (Prodotto prod : products) {

            if (prod.getFinalPrice() < min_price) {

                min_price = prod.getFinalPrice();
                minPriceProduct = prod;
            }
        }
        return minPriceProduct;
    }

    public double getAveragePrice() {
       
        List<Prodotto> products = findAll();

        if (products == null || products.isEmpty()) {
            return 0.0;
        }

        double averagePrice = 0.0;

        for (Prodotto prod : products) {

            averagePrice += prod.getFinalPrice();
        }

        averagePrice /= products.size();

        return averagePrice;
    }
}
