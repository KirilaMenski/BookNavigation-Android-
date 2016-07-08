package by.ansgar.android.booknavigationa.database;

import android.database.Cursor;

import java.util.UUID;

import by.ansgar.android.booknavigationa.database.entity.Book;

/**
 * Created by kirila on 8.7.16.
 */
public class CursorWrapper extends android.database.CursorWrapper {

    public CursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Book getBook(){
        String uuid = getString(getColumnIndex(DBSchema.BookTable.Cols.UUID));
        String cover = getString(getColumnIndex(DBSchema.BookTable.Cols.COVER));
        String title = getString(getColumnIndex(DBSchema.BookTable.Cols.TITLE));
        String published = getString(getColumnIndex(DBSchema.BookTable.Cols.PUBLISHED));
        String series = getString(getColumnIndex(DBSchema.BookTable.Cols.SERIES));
        String seriesNumb = getString(getColumnIndex(DBSchema.BookTable.Cols.NUMBER_SERIES));
        String description = getString(getColumnIndex(DBSchema.BookTable.Cols.DESCRIPTION));
        String authorName = getString(getColumnIndex(DBSchema.BookTable.Cols.AUTHOR_NAME));
        String read = getString(getColumnIndex(DBSchema.BookTable.Cols.READ));
        String inList = getString(getColumnIndex(DBSchema.BookTable.Cols.IN_LIST));

        Book book = new Book(UUID.fromString(uuid));
        book.setCover(cover);
        book.setTitle(title);
        book.setPublished(published);
        book.setSeries(series);
        book.setSeriesNumb(seriesNumb);
        book.setDescription(description);
        book.setAuthorName(authorName);
        book.setRead(read);
        book.setInList(inList);

        return book;
    }

}
