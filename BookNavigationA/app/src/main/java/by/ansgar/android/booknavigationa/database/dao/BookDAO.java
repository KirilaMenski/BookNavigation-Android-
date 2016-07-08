package by.ansgar.android.booknavigationa.database.dao;

import java.util.List;
import java.util.UUID;

import by.ansgar.android.booknavigationa.database.entity.Book;

/**
 * Created by kirila on 8.7.16.
 */
public interface BookDAO {

    public void addBook(Book book);

    public void editBook(Book book);

    public void deleteBook(Book book);

    public Book getBookById(UUID id);

    public List<Book> getAllBooks();


}
