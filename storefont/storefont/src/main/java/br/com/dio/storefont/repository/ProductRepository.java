package br.com.dio.storefont.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dio.storefont.entity.ProductEntity;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID>{
    List<ProductEntity> findByActiveTrueOrderByNameAsc();
}
