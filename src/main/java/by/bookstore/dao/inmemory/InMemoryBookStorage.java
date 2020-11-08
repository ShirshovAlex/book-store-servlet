package by.bookstore.dao.inmemory;

import by.bookstore.entity.Author;
import by.bookstore.entity.Book;
import by.bookstore.dao.BookStorage;
import by.bookstore.entity.Category;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InMemoryBookStorage implements BookStorage {
    private static final Book[] books = new Book[50];
    private static int size = 0;

    static {
        books[0] = new Book(1, "Test", "Test", new Author(1, "Test"), new Category("test2"),BigDecimal.valueOf(22));
        books[1] = new Book(2, "Test2", "Test2", new Author(1, "Test"), new Category("test2"),BigDecimal.valueOf(33));
        books[2] = new Book(3, "Test3", "Test", new Author(1, "Test"), new Category("test2"),BigDecimal.valueOf(44));
        size = 3;
    }

    @Override
    public Book add(Book book) {
        if (books.length == size) return null;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                size++;
                return book;
            }
        }
        return null;
    }

    @Override
    public Book remove(int id) {
        checkId(id);
        Book old;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId() == id) {
                old = books[i];
                for (int j = i; j < books.length - 1; j++) {
                    books[j] = books[j + 1];
                }
                size--;
                return old;
            }
        }
        return null;
    }

    private void checkId(int id) {
        if (size == 0 || id < 0) throw new IllegalStateException();
    }

    @Override
    public Book remove(Book book) {
        checkBook(book);
        Book old;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) break;
            if (books[i].equals(book)) {
                old = books[i];
                for (int j = i; j < books.length - 1; j++) {
                    books[j] = books[j + 1];
                }
                size--;
                return old;
            }
        }
        return null;
    }

    private void checkBook(Book book) {
        if (book == null || size == 0) throw new NullPointerException();
    }

    @Override
    public Book updateTitle(String title, int id) {
        checkId(id);
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId() == id) {
                Book book = books[i];
                book.setTitle(title);
                return book;
            }
        }

        return null;
    }


    @Override
    public Book updateAuthor(Author author, int id) {
        checkId(id);
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId() == id) {
                Book book = books[i];
                book.setAuthor(author);
                return book;
            }
        }
        return null;
    }

    @Override
    public Book updateDescription(String desc, int id) {
        checkId(id);
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId() == id) {
                Book book = books[i];
                book.setDescription(desc);
                return book;
            }
        }
        return null;
    }

    @Override
    public Book updateId(int id) {
        checkId(id);
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId() == id) {
                Book book = books[i];
                book.setId(id);
                return book;
            }
        }
        return null;
    }

    @Override
    public Book updatePrice(double price, int id) {
        checkId(id);
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId() == id) {
                Book book = books[i];
                book.setPrice(BigDecimal.valueOf(price));
                return book;
            }
        }
        return null;
    }

    @Override
    public Book[] getAll() {
        int count = 0;
        int count2 = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                count++;
            }
        }
        Book[] bookAll = new Book[count];
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                bookAll[count2] = books[i];
                count2++;
            }
        }
        return bookAll;
    }

    @Override
    public Book getById(int id) {
        checkId(id);
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId() == id) {
                return books[i];
            }
        }
        return null;
    }

    @Override
    public Book[] getByTitle(String title) {
        int count = 0;
        int count2 = 0;
        for (Book book : books) {
            if (book == null) continue;
            if (book.getTitle().equals(title)) {
                count++;
            }
        }
        Book[] bookTittle = new Book[count];
        for (Book book : books) {
            if (book == null) continue;
            if (book.getTitle().equals(title)) {
                bookTittle[count2++] = book;
            }
        }
        return bookTittle;
    }

    @Override
    public Book[] getByAuthor(Author author) {
        int count = 0;
        int count2 = 0;
        for (Book book : books) {
            if (book == null) continue;
            if (book.getAuthor().equals(author)) {
                count++;
            }
        }
        Book[] bookAuthor = new Book[count];
        for (Book book : books) {
            if (book == null) continue;
            if (book.getAuthor().equals(author)) {
                bookAuthor[count2++] = book;
            }
        }
        return bookAuthor;
    }

    @Override
    public Book[] getByPrice(double price) {
        int count = 0;
        int count2 = 0;

        for (Book book : books) {
            if (book == null) continue;
            if (book.getPrice().doubleValue() == price) {
                count++;
            }
        }

        Book[] bookPrice = new Book[count];

        for (Book book : books) {
            if (book == null) continue;
            if (book.getPrice().doubleValue() == price) {
                bookPrice[count2++] = book;
            }
        }
        return bookPrice;
    }

    @Override
    public Book[] getAllByCategoryId(int id) {
        List<Book> list = new ArrayList<>();
        for (Book book : books) {
            if (book == null) break;
            if (book.getCategory().getId() == id){
                list.add(book);
            }
        }
        return list.toArray(new Book[0]);
    }

    @Override
    public boolean contains(int id) {
        for (Book book : books) {
            if (book == null) break;
            if (book.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Book book) {
        for (Book value : books) {
            if (value == null) break;
            if (value.equals(book)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<Book> searchByTitle(String title) {
        List<Book> list = new ArrayList<>();
        for (Book book : books) {
            if (book == null) break;
            if(book.getTitle().equalsIgnoreCase(title)){
                list.add(book);
            }
        }
        return list;
    }

    @Override
    public List<Book> searchByDesc(String desc) {
        List<Book> list = new ArrayList<>();
        for (Book book : books) {
            if (book == null) break;
            if(book.getDescription().equalsIgnoreCase(desc)){
                list.add(book);
            }
        }
        return list;
    }

    @Override
    public List<Book> searchByCategory(String category) {
        List<Book> list = new ArrayList<>();
        for (Book book : books) {
            if (book == null) break;
            if(book.getCategory().getName().equalsIgnoreCase(category)){
                list.add(book);
            }
        }
        return list;
    }

}