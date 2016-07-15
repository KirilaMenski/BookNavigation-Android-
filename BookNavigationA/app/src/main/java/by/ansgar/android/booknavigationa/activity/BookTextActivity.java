package by.ansgar.android.booknavigationa.activity;

import android.support.v4.app.Fragment;

import java.util.UUID;

import by.ansgar.android.booknavigationa.fragment.BookTextFragment;
import by.ansgar.android.booknavigationa.utils.SingleFragmentActivity;

/**
 * Created by kirila on 15.7.16.
 */
public class BookTextActivity extends SingleFragmentActivity {

    public static final String BOOK_TEXT_ID = "by.ansgar.android.booknavigationa.activity.book_text_id";

    @Override
    protected Fragment createFragment() {
        UUID id = (UUID)getIntent().getSerializableExtra(BOOK_TEXT_ID);
        return new BookTextFragment(id);
    }
}
