package br.com.lpr.repositories.products;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lpr.entities.products.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> { }