package by.bookstore.service;

import by.bookstore.entity.Author;
import by.bookstore.entity.Book;
import by.bookstore.dao.BookStorage;
import by.bookstore.dao.inmemory.InMemoryBookStorage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookServiceImpl implements BookService {
    private final BookStorage bookStorage = new InMemoryBookStorage();

    @Override
    public Book save(Book book) {
        if (bookStorage.contains(book)) return null;
        String title = book.getTitle().toUpperCase();
        book.setTitle(title);
        return bookStorage.add(book);
    }

    @Override
    public Book delete(int id) {
        if (bookStorage.contains(id)) {
            return bookStorage.remove(id);
        }
        return null;
    }

    @Override
    public Book delete(Book book) {
        if (bookStorage.contains(book)) {
            return bookStorage.remove(book);
        }
        return null;
    }

    @Override
    public Book updateTitleById(String title, int id) {
        if (bookStorage.contains(id)) {
            return bookStorage.updateTitle(title, id);
        }
        return null;
    }

    @Override
    public Book updateDescriptionById(String desc, int id) {
        if (bookStorage.contains(id)) {
            return bookStorage.updateDescription(desc, id);
        }
        return null;
    }

    @Override
    public Book updateAuthorById(Author author, int id) {
        if (bookStorage.contains(id)) {
            return bookStorage.updateAuthor(author, id);
        }
        return null;
    }

    @Override
    public Book updatePriceById(double price, int id) {
        if (bookStorage.contains(id)) {
            return bookStorage.updatePrice(price, id);
        }
        return null;
    }

    @Override
    public Book[] findAll() {
        return bookStorage.getAll();
    }

    @Override
    public Book[] findAllByTitle(String title) {
        return bookStorage.getByTitle(title.toUpperCase());
    }

    @Override
    public Book[] findAllByAuthor(Author author) {
        return bookStorage.getByAuthor(author);
    }

    @Override
    public Book[] findAllByPrice(double price) {
        return bookStorage.getByPrice(price);
    }

    @Override
    public Book findById(int id) {
        if (bookStorage.contains(id)) {
            return bookStorage.getById(id);
        }
        return null;
    }

    @Override
    public Book[] findAllByCategoryId(int id) {
        if(bookStorage.contains(id)){
            return bookStorage.getAllByCategoryId(id);
        }
        return null;
    }

    @Override
    public List<Book> search(String query) {
        List<Book> list = bookStorage.searchByCategory(query);
        List<Book> list1 = bookStorage.searchByDesc(query);
        List<Book> list2 = bookStorage.searchByTitle(query);

        Set<Book> objects = new HashSet<>();
        objects.addAll(list);
        objects.addAll(list1);
        objects.addAll(list2);

        return new ArrayList<>(objects);
    }
}
