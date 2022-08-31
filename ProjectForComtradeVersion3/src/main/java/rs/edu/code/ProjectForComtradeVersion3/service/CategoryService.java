package rs.edu.code.ProjectForComtradeVersion3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.code.ProjectForComtradeVersion3.dao.CategoryRepository;
import rs.edu.code.ProjectForComtradeVersion3.model.Category;
import rs.edu.code.ProjectForComtradeVersion3.model.People;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Grupa sa id-em " + id + " ne postoji"));
    }

    public Category update(Category updateCategory) {
        Category dbCategory = getById(updateCategory.getId());
        dbCategory.setCategory(updateCategory.getCategory());
        return categoryRepository.save(dbCategory);
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }








}
