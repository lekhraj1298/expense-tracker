package com.example.expense_tracker.controller;

import com.example.expense_tracker.Models.Category;
import com.example.expense_tracker.Service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/test")
    public ResponseEntity<List<Category>> getCategory() {
        return ResponseEntity.ok().body(categoryService.getCategory());
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody List<Category> categoryList) {
        categoryService.saveCategories(categoryList);
        return new ResponseEntity<>("Categories Saved", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<String> delete(@PathVariable ("id") Long categoryId){
        categoryService.delete(categoryId);
        return ResponseEntity.ok().body("Address deleted successfully");
    }

}