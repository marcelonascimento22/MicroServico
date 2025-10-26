package br.com.dio.storefont.controller;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import br.com.dio.storefont.controller.request.ProductSaveRequest;
import br.com.dio.storefont.controller.response.ProductAvailableResponse;
import br.com.dio.storefont.controller.response.ProductDetailResponse;
import br.com.dio.storefont.controller.response.ProductSaveResponse;
import br.com.dio.storefont.mapper.IProductMapper;
import br.com.dio.storefont.service.IProductService;


@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {

    private final IProductService service;

    private IProductMapper mapper;

    @PostMapping
    @ResponseStatus(CREATED)
    ProductSaveResponse create(@RequestBody final ProductSaveRequest request){
        var entity = mapper.toEntity(request);
        entity = service.save(entity);
        return mapper.toResponse(entity);
    }

    @PostMapping("{id}/purchase")
    @ResponseStatus(NO_CONTENT)
    void purchase(@PathVariable UUID id){
        service.purchase(id);
    }

    @GetMapping
    List<ProductAvailableResponse> listAvailable(){
        var entities = service.findAllActive();
        return mapper.toResponse(entities);
    }

    @GetMapping("{id}")
    ProductDetailResponse findById(@PathVariable final UUID id) {
       var dto = service.findInfo(id);
       return mapper.toResponse(dto);
    }
}
