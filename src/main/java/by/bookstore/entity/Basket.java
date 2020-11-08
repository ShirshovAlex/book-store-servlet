package by.bookstore.entity;

import java.util.Arrays;
import java.util.List;

public class Basket {
    private static int incId = 1;
    private final int id = incId++;

    private final Book[] books;

    public Basket(Book[] books) {
        this.books = books;
    }

    public boolean addBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                return true;
            }
        }
        return false;
    }

    public Book[] getBooks() {
        return Arrays.asList(books).toArray(new Book[0]);
    }

    public int countBooks() {
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) break;
            if (books[i] != null) {
                count++;
            }
        }
        return count;
    }

    public boolean isEmpty(){
        return books[0] == null;
    }


    public double totalPrice() {
        double total = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                break;
            }
            total += books[i].getPrice().doubleValue();
        }
        return total;
    }
}
