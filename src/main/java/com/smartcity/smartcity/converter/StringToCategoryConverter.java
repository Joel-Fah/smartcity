package com.smartcity.smartcity.converter;

import com.smartcity.smartcity.model.Category;
import com.smartcity.smartcity.service.CategoryService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCategoryConverter implements Converter<String, Category> {

    private final CategoryService categoryService;

    public StringToCategoryConverter(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public Category convert(String source) {
        return categoryService.getCategoryById(Long.parseLong(source));
    }
}