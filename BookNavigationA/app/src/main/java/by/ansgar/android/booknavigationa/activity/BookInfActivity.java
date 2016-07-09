package by.ansgar.android.booknavigationa.activity;

import android.support.v4.app.Fragment;

import java.util.UUID;

import by.ansgar.android.booknavigationa.fragment.BookInfFragment;
import by.ansgar.android.booknavigationa.utils.SingleFragmentActivity;

/**
 * Created by kirila on 8.7.16.
 */
public class BookInfActivity extends SingleFragmentActivity {

    public static final String BOOK_ID = "by.ansgar.android.booknavigationa.activity.book_id";

    @Override
    protected Fragment createFragment() {
        UUID id = (UUID) getIntent().getSerializableExtra(BOOK_ID);
        return new BookInfFragment(id);
    }

}
