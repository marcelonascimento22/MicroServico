package br.com.dio.storefont.service;

import java.util.List;
import java.util.UUID;

import br.com.dio.storefont.dto.ProductInfoDTO;
import br.com.dio.storefont.entity.ProductEntity;

public interface IProductService {

    ProductEntity save(final ProductEntity entity);

    void changeActivated(final UUID id, final boolean active);

    List<ProductEntity> findAllActive();

    ProductInfoDTO findInfo(final UUID id);

    void purchase(final UUID id);
}
