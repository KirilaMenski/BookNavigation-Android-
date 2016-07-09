package by.ansgar.android.booknavigationa.database;

/**
 * Created by kirila on 8.7.16.
 */
public class DBSchema {

    public static final class BookTable{

        public static final String NAME = "books";

        public static class Cols{
            public static final String UUID = "id";
            public static final String COVER = "cover";
            public static final String TITLE = "title";
            public static final String GENRE = "genre";
            public static final String PUBLISHED = "published";
            public static final String SERIES = "series";
            public static final String NUMBER_SERIES = "number_series";
            public static final String DESCRIPTION = "description";
            public static final String AUTHOR_NAME = "author_name";
            public static final String READ = "read";
            public static final String IN_LIST = "in_list";
        }

    }

}
