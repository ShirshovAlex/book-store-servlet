package by.bookstore.service;

import by.bookstore.dao.CategoryStorage;
import by.bookstore.dao.inmemory.InMemoryCategoryStorage;
import by.bookstore.entity.Category;

public class CategoryServiceImpl implements CategoryService{

    private CategoryStorage categoryStorage = new InMemoryCategoryStorage();

    @Override
    public boolean save(Category category) {
        if(categoryStorage.contains(category.getName())){
            return false;
        }
        categoryStorage.save(category);
        return true;
    }

    @Override
    public Category deleteByName(String name) {
        if (categoryStorage.contains(name)) {
            categoryStorage.deleteByName(name);
        }
        return null;
    }

    @Override
    public Category deleteById(int id) {
        if (categoryStorage.contains(id)) {
            Category category = categoryStorage.deleteById(id);
            return category;
        }
        return null;
    }

    @Override
    public Category[] findAll() {
        return categoryStorage.findAll();
    }

    @Override
    public Category findByName(String name) {
        if(categoryStorage.contains(name)){
            return categoryStorage.findByName(name);
        }
        return null;
    }

    @Override
    public Category findById(int id) {
        if(categoryStorage.contains(id)){
            return categoryStorage.findById(id);
        }
        return null;
    }

    @Override
    public Category updateNameById(String name, int id) {
        if (categoryStorage.contains(id)) {
            return categoryStorage.updateNameById(name, id);
        }
        return null;
    }
}
