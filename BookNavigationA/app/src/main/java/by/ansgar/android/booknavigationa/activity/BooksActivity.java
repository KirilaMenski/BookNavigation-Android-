package by.ansgar.android.booknavigationa.activity;

import android.support.v4.app.Fragment;

import by.ansgar.android.booknavigationa.fragment.BooksFragment;
import by.ansgar.android.booknavigationa.utils.SingleFragmentActivity;

/**
 * Created by kirila on 8.7.16.
 */
public class BooksActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new BooksFragment();
    }
}
