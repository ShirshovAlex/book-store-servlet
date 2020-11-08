package by.bookstore.dao;

import by.bookstore.entity.Category;

public interface CategoryStorage {

    boolean save(Category category);

    Category deleteByName(String name);
    Category deleteById(int id);

    Category[] findAll();
    Category findByName(String name);
    Category findById(int id);

    Category updateNameById(String name, int id);

    boolean contains (int id);

    boolean contains(String name);

}
