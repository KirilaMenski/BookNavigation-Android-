package by.ansgar.android.booknavigationa.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.UUID;

import by.ansgar.android.booknavigationa.R;
import by.ansgar.android.booknavigationa.database.dao.BookDAO;
import by.ansgar.android.booknavigationa.database.daoImpl.BookDAOImpl;
import by.ansgar.android.booknavigationa.database.entity.Book;

/**
 * Created by kirila on 8.7.16.
 */
public class BookInfFragment extends Fragment {

    private UUID mId;
    private BookDAO mBookDAO;
    private Book mBook;

    private ImageView mCover;
    private TextView mTitle, mAuthor, mPublish, mGenre, mSeries, mDescription;
    private Button mRead, mAddList, mWasReading;

    private Resources mResources;

    public BookInfFragment(UUID id){
        this.mId = id;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_inf_fragment, container, false);
        mResources = getResources();

        mBookDAO = new BookDAOImpl(getActivity());
        mBook = mBookDAO.getBookById(mId);

        mCover = (ImageView) view.findViewById(R.id.book_inf_cover);
        mCover.setImageDrawable(mResources.getDrawable(R.drawable.default_cover));
        mTitle = (TextView) view.findViewById(R.id.book_inf_title);
        mTitle.setText("" + mId);
        mAuthor = (TextView) view.findViewById(R.id.book_inf_author);
        mPublish = (TextView) view.findViewById(R.id.book_inf_publish);
        mGenre = (TextView) view.findViewById(R.id.book_inf_genre);
        mSeries = (TextView) view.findViewById(R.id.book_inf_series);
        mDescription = (TextView) view.findViewById(R.id.book_inf_description);
        mDescription.setText("The serial number of book is " + mId);

        return view;
    }
}
