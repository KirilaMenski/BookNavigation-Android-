package by.ansgar.android.booknavigationa.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kirila on 8.7.16.
 */
public class BaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "book.db";

    public BaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + DBSchema.BookTable.NAME
                        + "("
                        + " _id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + DBSchema.BookTable.Cols.UUID + " text , "
                        + DBSchema.BookTable.Cols.PATH + " text , "
                        + DBSchema.BookTable.Cols.COVER + " text , "
                        + DBSchema.BookTable.Cols.TITLE + " text , "
                        + DBSchema.BookTable.Cols.GENRE + " text , "
                        + DBSchema.BookTable.Cols.PUBLISHED + " text , "
                        + DBSchema.BookTable.Cols.SERIES + " text , "
                        + DBSchema.BookTable.Cols.NUMBER_SERIES + " text , "
                        + DBSchema.BookTable.Cols.DESCRIPTION + " text, "
                        + DBSchema.BookTable.Cols.AUTHOR_NAME + " text, "
                        + DBSchema.BookTable.Cols.READ + " text, "
                        + DBSchema.BookTable.Cols.IN_LIST + " text"
                        + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
