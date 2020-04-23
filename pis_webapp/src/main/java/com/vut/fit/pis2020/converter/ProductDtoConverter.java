package com.vut.fit.pis2020.converter;

import com.vut.fit.pis2020.dto.ProductBasicDto;
import com.vut.fit.pis2020.dto.ProductDto;
import com.vut.fit.pis2020.dto.ProductPhotoDto;
import com.vut.fit.pis2020.entity.Product;
import com.vut.fit.pis2020.entity.ProductPhoto;
import com.vut.fit.pis2020.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDtoConverter {

    @Autowired
    ProductService productService;

    public Product convertToProduct(ProductDto productDto) {
        Product product = null;

        if(productDto != null) {
            product = new Product();
            product.setName(productDto.getName());
            product.setSpecification(productDto.getSpecification());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
            product.setAvailable(productDto.getAvailable());
        }

        return product;
    }

    public ProductDto convertToProductDto(Product product) {
        ProductDto productDto = null;

        if(product != null) {
            productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setName(product.getName());
            productDto.setSpecification(product.getSpecification());
            productDto.setDescription(product.getDescription());
            productDto.setPrice(product.getPrice());    // TODO
            productDto.setPriceTax(product.getPrice() * 1.20); // TAX
            productDto.setInDiscount(false);    // TODO
            productDto.setBeforeDiscountPrice(null);
            productDto.setAvailable(product.getAvailable());

            List<ProductPhoto> productPhotos = productService.findPhotosByProduct(product.getId());

            List<Long> productPhotoIds = new ArrayList<>();
            for (ProductPhoto productPhoto: productPhotos) {
                productPhotoIds.add(productPhoto.getId());
            }
            productDto.setPhotoIds(productPhotoIds);
        }

        return productDto;
    }

    public ProductBasicDto convertToProductBasicDto(Product product) {
        ProductBasicDto productBasicDto = null;

        if(product != null) {
            productBasicDto = new ProductBasicDto();
            productBasicDto.setId(product.getId());
            productBasicDto.setName(product.getName());
            productBasicDto.setPrice(product.getPrice());    // TODO
            productBasicDto.setInDiscount(false);    // TODO
            productBasicDto.setAvailable(product.getAvailable());
        }

        return productBasicDto;
    }

    public ProductPhotoDto convertToProductPhotoDto(ProductPhoto productPhoto) {
        ProductPhotoDto productPhotoDto = null;

        if(productPhoto != null) {
            productPhotoDto = new ProductPhotoDto();
            productPhotoDto.setId(productPhoto.getId());
            productPhotoDto.setName(productPhoto.getName());
            productPhotoDto.setDescription(productPhoto.getDescription());
            productPhotoDto.setFile(productPhoto.getFile());
            productPhotoDto.setProductId(productPhoto.getProduct().getId());
        }

        return productPhotoDto;
    }

    public ProductPhoto convertToProductPhoto(ProductPhotoDto productPhotoDto) {
        ProductPhoto productPhoto = null;

        if(productPhotoDto != null) {
            productPhoto = new ProductPhoto();
            productPhoto.setName(productPhotoDto.getName());
            productPhoto.setDescription(productPhotoDto.getDescription());
            productPhoto.setFile(productPhotoDto.getFile());
            productPhoto.setProduct(productService.findById(productPhotoDto.getProductId()));
        }

        return productPhoto;
    }
}
