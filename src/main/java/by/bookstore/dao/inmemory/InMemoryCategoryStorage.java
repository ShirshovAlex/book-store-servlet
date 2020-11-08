package by.bookstore.dao.inmemory;

import by.bookstore.dao.CategoryStorage;
import by.bookstore.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCategoryStorage implements CategoryStorage {
    private static List<Category> categories = new ArrayList<>();

    static {
        categories.add(new Category(1, "test"));
        categories.add(new Category(2, "test3"));
        categories.add(new Category(3, "test2"));
    }

    @Override
    public boolean save(Category category) {
        return categories.add(category);
    }

    @Override
    public Category deleteByName(String name) {
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                Category olf = category;
                categories.remove(category);
                return olf;
            }
        }
        return null;
    }

    @Override
    public Category deleteById(int id) {
        for (Category category : categories) {
            if (category.getId() == id) {
                Category olf = category;
                categories.remove(category);
                return olf;
            }
        }
        return null;
    }

    @Override
    public Category[] findAll() {
        return categories.toArray(new Category[0]);
    }

    @Override
    public Category findByName(String name) {
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        return null;
    }

    @Override
    public Category findById(int id) {
        for (Category category : categories) {
            if (category.getId()==id) {
                return category;
            }
        }
        return null;
    }

    @Override
    public Category updateNameById(String name, int id) {
        for (Category category : categories) {
            if (category.getId()==id) {
                category.setName(name);
            }
        }
        return null;
    }

    @Override
    public boolean contains(int id) {
        for (Category category : categories) {
            if (category.getId()==id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(String name) {
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
