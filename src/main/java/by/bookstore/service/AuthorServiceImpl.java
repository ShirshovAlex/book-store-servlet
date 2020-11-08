package by.bookstore.service;

import by.bookstore.dao.AuthorStorage;
import by.bookstore.dao.inmemory.InMemoryAuthorStorage;
import by.bookstore.entity.Author;

public class AuthorServiceImpl implements AuthorService {
    private final AuthorStorage authorStorage = new InMemoryAuthorStorage();


    @Override
    public Author save(Author author) {
        if (authorStorage.contains(author)) return null;
        return authorStorage.add(author);
    }

    @Override
    public Author delete(int id) {
        if (authorStorage.contains(id)) {
            return authorStorage.remove(id);
        }
        return null;
    }

    @Override 
    public Author delete(Author author) {
        if (authorStorage.contains(author)) {
            return authorStorage.remove(author);
        }
        return null;
    }


    @Override
    public Author updateName(String name, int id) {
        if (authorStorage.contains(id)) {
            return authorStorage.update(name, id);
        }
        return null;
    }

    @Override
    public Author[] findAll() {
        return authorStorage.getAll();
    }

    @Override
    public Author findById(int id) {
        if (authorStorage.contains(id)) {
            return authorStorage.getById(id);
        }
        return null;
    }

    @Override
    public Author[] findByName(String name) {
        return authorStorage.getByName(name);
    }
}
