package com.vut.fit.pis2020.controller.restController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vut.fit.pis2020.converter.CategoryDtoConverter;
import com.vut.fit.pis2020.dto.CategoryDto;
import com.vut.fit.pis2020.dto.UserDto;
import com.vut.fit.pis2020.entity.Category;
import com.vut.fit.pis2020.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryDtoConverter categoryDtoConverter;

    @Autowired
    private ObjectMapper jsonObjectMapper;

    @GetMapping("/api/admin/categories")
    public List<CategoryDto> getAllCategories() {

        List<Category> allCategories = categoryService.findAll();
        List<CategoryDto> allCategoriesDto = new ArrayList<>();

        for(Category category: allCategories) {
            allCategoriesDto.add(categoryDtoConverter.convertToCategoryDto(category));
        }

        return allCategoriesDto;
    }

    @GetMapping("/api/admin/categories/{categoryId}")
    public CategoryDto getCategory(@PathVariable("categoryId") Long categoryId) {

        Category category = categoryService.findById(categoryId);

        return categoryDtoConverter.convertToCategoryDto(category);
    }

    @PostMapping("/api/admin/categories/create")
    public HashMap<String, String> createCategory(@RequestBody String categoryJSON) throws JsonProcessingException {

        HashMap<String, String> returnCode = new HashMap<>();

        CategoryDto categoryDto = jsonObjectMapper.readValue(categoryJSON, CategoryDto.class);

        if(categoryDto.getParentCategoryId() != null) {

            if(categoryService.findById(categoryDto.getParentCategoryId()) == null) {
                returnCode.put("409", "There is no parent category with this id provided");

                return returnCode;
            }
        }

        Category category = categoryDtoConverter.convertToCategory(categoryDto);

        categoryService.save(category);

        returnCode.put("201", "Category created");

        return returnCode;
    }

    @PostMapping("/api/admin/categories/update")
    public HashMap<String, String> updateCategory(@RequestBody String categoryJSON) throws JsonProcessingException {

        HashMap<String, String> returnCode = new HashMap<>();

        CategoryDto categoryDto = jsonObjectMapper.readValue(categoryJSON, CategoryDto.class);

        Category category = categoryService.findById(categoryDto.getId());

        if(category == null) {
            returnCode.put("409", "There is no category with this id");

            return returnCode;
        }

        if(categoryDto.getParentCategoryId() != null) {

            if(categoryService.findById(categoryDto.getParentCategoryId()) == null) {
                returnCode.put("409", "There is no parent category with this id provided");

                return returnCode;
            }
        }

        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        category.setParentCategory(categoryService.findById(categoryDto.getParentCategoryId()));

        categoryService.save(category);

        returnCode.put("201", "User updated");

        return returnCode;
    }
}
