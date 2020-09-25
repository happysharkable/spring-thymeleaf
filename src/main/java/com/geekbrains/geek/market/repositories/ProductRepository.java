package com.geekbrains.geek.market.repositories;

import com.geekbrains.geek.market.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.title = :title, p.price = :price WHERE p.id = :id")
    void editProduct(@Param("id") Long id, @Param("title") String title, @Param("price") int price);
}
