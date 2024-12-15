package com.shabab.aiproject.funcs;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BookService {

    private static final Map<Integer,Book> books = new ConcurrentHashMap<>();

    static {
        books.put(1, new Book("His Dark Materials", "Philip Pullman"));
        books.put(2, new Book("Narnia", "Lib Koohi"));
        books.put(3, new Book("Dila", "Shabab Koohi"));
        books.put(4, new Book("The Hobbit", "J.R.R. Tolkien"));
        books.put(5, new Book("The Lord of The Rings", "J.R.R. Tolkien"));
        books.put(6, new Book("The Silmarillion", "J.R.R. Tolkien"));
    }

    List<Book> getBooksByAuthor(Author author) {
        return books.values().stream()
                .filter(book -> author.name().equalsIgnoreCase(book.author()))
                .toList();
    }

    public record Book(String title, String author) {}
    public record Author(String name) {}

}