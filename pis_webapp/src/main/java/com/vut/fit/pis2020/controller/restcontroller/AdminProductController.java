package com.vut.fit.pis2020.controller.restcontroller;

import com.vut.fit.pis2020.converter.ProductDtoConverter;
import com.vut.fit.pis2020.dto.ProductBasicDto;
import com.vut.fit.pis2020.dto.ProductDto;
import com.vut.fit.pis2020.dto.ProductPhotoDto;
import com.vut.fit.pis2020.entity.Product;
import com.vut.fit.pis2020.entity.ProductPhoto;
import com.vut.fit.pis2020.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDtoConverter productDtoConverter;

    @GetMapping("/api/admin/products")
    public List<ProductBasicDto> getAllProducts() {

        List<Product> allProducts = productService.findAll();
        List<ProductBasicDto> allProductsBasicDto = new ArrayList<>();

        for(Product product: allProducts) {
            allProductsBasicDto.add(productDtoConverter.convertToProductBasicDto(product));
        }

        return allProductsBasicDto;
    }

    @GetMapping("/api/admin/products/{productId}")
    public ProductDto getProductDetail(@PathVariable("productId") Long productId) {

        Product product = productService.findById(productId);

        return productDtoConverter.convertToProductDto(product);
    }

    @PostMapping("/api/admin/products/create")
    public HashMap<String, String> createProduct(@ModelAttribute("product") ProductDto productDto) {

        HashMap<String, String> returnCode = new HashMap<>();

        Product product = productDtoConverter.convertToProduct(productDto);

        productService.save(product);

        returnCode.put("201", "Product created");

        return returnCode;
    }

    @PostMapping("/api/admin/products/update")
    public HashMap<String, String> updateProduct(@ModelAttribute("product") ProductDto productDto) {

        HashMap<String, String> returnCode = new HashMap<>();

        Product product = productService.findById(productDto.getId());

        if(product == null) {
            returnCode.put("409", "There is no product with this id");

            return returnCode;
        }

        product.setName(productDto.getName());
        product.setSpecification(productDto.getSpecification());
        product.setPrice(productDto.getPrice());
        product.setAvailable(productDto.getAvailable());

        productService.save(product);

        returnCode.put("201", "Product created");

        return returnCode;
    }

    @GetMapping("/api/admin/products/{productId}/photos")
    public List<ProductPhotoDto> getProductPhotos(@PathVariable("productId") Long productId) {

        List<ProductPhoto> productPhotos = productService.findPhotosByProduct(productId);
        List<ProductPhotoDto> productPhotoDtos = new ArrayList<>();

        for (ProductPhoto productPhoto: productPhotos) {
            productPhotoDtos.add(productDtoConverter.convertToProductPhotoDto(productPhoto));
        }

        return productPhotoDtos;
    }

    @GetMapping("/api/admin/products/{productId}/photos/{photoId}")
    public ProductPhotoDto getProductPhoto(@PathVariable("productId") Long productId, @PathVariable("photoId") Long photoId) {

        ProductPhoto productPhoto = productService.findPhotoById(photoId);

        if(!productPhoto.getProduct().getId().equals(productId)) {
            return null;
        }

        return productDtoConverter.convertToProductPhotoDto(productPhoto);
    }

    @PostMapping("/api/admin/products/photos/create")
    public HashMap<String, String> createProductPhoto(@ModelAttribute("photo") ProductPhotoDto productPhotoDto) {

        HashMap<String, String> returnCode = new HashMap<>();

        if(productService.findById(productPhotoDto.getProductId()) == null) {
            returnCode.put("409", "There is no product with this id");

            return returnCode;
        }

        ProductPhoto productPhoto = productDtoConverter.convertToProductPhoto(productPhotoDto);

        productService.savePhoto(productPhoto);

        returnCode.put("201", "Product photo added");

        return returnCode;
    }

    @PostMapping("/api/admin/products/photos/update")
    public HashMap<String, String> updateProductPhoto(@ModelAttribute("photo") ProductPhotoDto productPhotoDto) {

        HashMap<String, String> returnCode = new HashMap<>();

        ProductPhoto productPhoto = productService.findPhotoById(productPhotoDto.getId());

        if(productPhoto == null) {
            returnCode.put("409", "There is no photo with this id");

            return returnCode;
        }

        Product product = productService.findById(productPhotoDto.getProductId());

        if(product == null) {
            returnCode.put("409", "There is no product with this id");

            return returnCode;
        }

        productPhoto.setName(productPhotoDto.getName());
        productPhoto.setDescription(productPhotoDto.getDescription());
        productPhoto.setFile(productPhotoDto.getFile());
        productPhoto.setProduct(product);

        productService.savePhoto(productPhoto);

        returnCode.put("201", "Product photo updated");

        return returnCode;
    }

    @PostMapping("/api/admin/products/photos/delete")
    public HashMap<String, String> deleteProductPhoto(@ModelAttribute("photoId") Long photoId) {

        HashMap<String, String> returnCode = new HashMap<>();

        ProductPhoto productPhoto = productService.findPhotoById(photoId);

        if(productPhoto == null) {
            returnCode.put("409", "There is no photo with this id");

            return returnCode;
        }

        productService.deletePhoto(productPhoto);

        returnCode.put("201", "Product photo deleted");

        return returnCode;
    }
}
