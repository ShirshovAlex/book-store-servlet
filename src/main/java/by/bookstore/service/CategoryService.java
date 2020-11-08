package by.bookstore.service;

import by.bookstore.dao.CategoryStorage;
import by.bookstore.dao.inmemory.InMemoryCategoryStorage;
import by.bookstore.entity.Category;

public interface CategoryService {


    boolean save(Category category);

    Category deleteByName(String name);
    Category deleteById(int id);

    Category[] findAll();
    Category findByName(String name);
    Category findById(int id);

    Category updateNameById(String name, int id);


}
