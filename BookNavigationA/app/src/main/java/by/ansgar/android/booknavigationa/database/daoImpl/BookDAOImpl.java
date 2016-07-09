package by.ansgar.android.booknavigationa.database.daoImpl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import by.ansgar.android.booknavigationa.database.BaseHelper;
import by.ansgar.android.booknavigationa.database.CursorWrapper;
import by.ansgar.android.booknavigationa.database.DBSchema;
import by.ansgar.android.booknavigationa.database.dao.BookDAO;
import by.ansgar.android.booknavigationa.database.entity.Book;

/**
 * Created by kirila on 8.7.16.
 */
public class BookDAOImpl implements BookDAO {

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public BookDAOImpl(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new BaseHelper(mContext).getWritableDatabase();
    }

    @Override
    public void addBook(Book book) {
        ContentValues values = getContentValues(book);
        mDatabase.insert(DBSchema.BookTable.NAME, null, values);
    }

    @Override
    public void editBook(Book book) {
        String uuid = book.getId().toString();
        ContentValues values = getContentValues(book);
        mDatabase.update(DBSchema.BookTable.NAME,
                values,
                DBSchema.BookTable.Cols.UUID + " = ?",
                new String[]{uuid});
    }

    @Override
    public void deleteBook(Book book) {
        String uuid = book.getId().toString();
        mDatabase.delete(DBSchema.BookTable.NAME,
                DBSchema.BookTable.Cols.UUID + " = ?",
                new String[]{uuid});
    }

    @Override
    public Book getBookById(UUID id) {
        CursorWrapper cursor = query(
                DBSchema.BookTable.Cols.UUID + " = ?",
                new String[]{id.toString()}
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getBook();
        }finally {
            cursor.close();
        }
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Book book = new Book();
            book.setId(UUID.randomUUID());
            book.setTitle("Book #" + i);
            book.setDescription("Description #" + i);
            book.setAuthorName("Author #" +i);
            books.add(book);
        }
//        CursorWrapper cursor = query(null, null);
//        try{
//            cursor.moveToFirst();
//            while (!cursor.isAfterLast()){
//                books.add(cursor.getBook());
//                cursor.moveToNext();
//            }
//        }finally {
//            cursor.close();
//        }
        return books;
    }

    private ContentValues getContentValues(Book book){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBSchema.BookTable.Cols.UUID, book.getId().toString());
        contentValues.put(DBSchema.BookTable.Cols.COVER, book.getCover().toString());
        contentValues.put(DBSchema.BookTable.Cols.GENRE, book.getCover().toString());
        contentValues.put(DBSchema.BookTable.Cols.TITLE, book.getTitle());
        contentValues.put(DBSchema.BookTable.Cols.PUBLISHED, book.getPublished());
        contentValues.put(DBSchema.BookTable.Cols.SERIES, book.getSeries());
        contentValues.put(DBSchema.BookTable.Cols.NUMBER_SERIES, book.getSeriesNumb());
        contentValues.put(DBSchema.BookTable.Cols.DESCRIPTION, book.getDescription());
        contentValues.put(DBSchema.BookTable.Cols.AUTHOR_NAME, book.getAuthorName());
        contentValues.put(DBSchema.BookTable.Cols.READ, book.getRead());
        contentValues.put(DBSchema.BookTable.Cols.IN_LIST, book.getInList());

        return contentValues;
    }

    private CursorWrapper query(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query(
                DBSchema.BookTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
        return new CursorWrapper(cursor);
    }

}
