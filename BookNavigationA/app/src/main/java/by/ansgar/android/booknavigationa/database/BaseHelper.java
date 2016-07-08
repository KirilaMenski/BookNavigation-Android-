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
                        + DBSchema.BookTable.Cols.UUID + ", "
                        + DBSchema.BookTable.Cols.COVER + ", "
                        + DBSchema.BookTable.Cols.TITLE + ", "
                        + DBSchema.BookTable.Cols.PUBLISHED + ", "
                        + DBSchema.BookTable.Cols.SERIES + ", "
                        + DBSchema.BookTable.Cols.NUMBER_SERIES + ", "
                        + DBSchema.BookTable.Cols.DESCRIPTION + ", "
                        + DBSchema.BookTable.Cols.AUTHOR_NAME + ", "
                        + DBSchema.BookTable.Cols.READ + ", "
                        + DBSchema.BookTable.Cols.IN_LIST
                        + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
