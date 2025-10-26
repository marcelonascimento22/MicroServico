package br.com.dio.storefont.mapper;

import java.math.BigDecimal;
import java.util.List;

import br.com.dio.storefont.controller.request.ProductSaveRequest;
import br.com.dio.storefont.controller.response.ProductAvailableResponse;
import br.com.dio.storefont.controller.response.ProductDetailResponse;
import br.com.dio.storefont.controller.response.ProductSaveResponse;
import br.com.dio.storefont.dto.ProductInfoDTO;
import br.com.dio.storefont.entity.ProductEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IProductMapper{

    @Mapping(target = "price", source = "price")
    // Implement as a default method to avoid an IDE/Eclipse annotation-processor bug
    // that can occur when MapStruct processes multi-source parameter mappings
    // with some compilers. The default implementation preserves the same behavior
    // and prevents MapStruct from generating code for this method.
    default ProductInfoDTO toDTO(final ProductEntity entity, final BigDecimal price) {
        if (entity == null && price == null) {
            return null;
        }

        java.util.UUID id = null;
        String name = null;

        if (entity != null) {
            id = entity.getId();
            name = entity.getName();
        }

        return new ProductInfoDTO(id, name, price);
    }

    @Mapping(target = "active", constant = "false")
    ProductEntity toEntity(final ProductSaveRequest request);

    ProductSaveResponse toResponse(final ProductEntity entity);

    List<ProductAvailableResponse> toResponse(final List<ProductEntity> entities); 

    ProductDetailResponse toResponse(final ProductInfoDTO dto);

}
