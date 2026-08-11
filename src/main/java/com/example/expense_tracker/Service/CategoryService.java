package com.example.expense_tracker.Service;

import com.example.expense_tracker.Models.Category;
import com.example.expense_tracker.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository = null;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategory(){
       return categoryRepository.findAll();
    }

    public void saveCategories(List<Category> categoryList){
         categoryRepository.saveAll(categoryList);
    }

    public void delete(Long categoryId){
        categoryRepository.deleteById(categoryId);
    }


}
