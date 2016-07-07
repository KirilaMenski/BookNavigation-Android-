package by.ansgar.android.booknavigationa.activity;

import android.support.v4.app.Fragment;

import by.ansgar.android.booknavigationa.fragment.AuthorsFragment;
import by.ansgar.android.booknavigationa.utils.SingleFragmentActivity;

public class AuthorsActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new AuthorsFragment();
    }
}
