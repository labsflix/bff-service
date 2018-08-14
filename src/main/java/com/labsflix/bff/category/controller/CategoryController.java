package com.labsflix.bff.category.controller;

import java.util.List;

import com.labsflix.bff.category.service.CategoryService;
import com.labsflix.bff.category.vo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(path="/categories", method = RequestMethod.GET, name="getCategories")
	public List<Category> getCategories() {
		List<Category> categories = categoryService.getCategoryList();
		return categories;
	}
	
	@RequestMapping(path="/categories/{id}", method=RequestMethod.GET, name="getCategory")
	public Category getCategory(@PathVariable(value = "id") String id) {
		Category category = categoryService.getCategory(id);
		return category;
	}

}
