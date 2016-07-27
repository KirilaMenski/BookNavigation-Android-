package by.ansgar.android.booknavigationa.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import by.ansgar.android.booknavigationa.R;
import by.ansgar.android.booknavigationa.database.dao.BookDAO;
import by.ansgar.android.booknavigationa.database.daoImpl.BookDAOImpl;
import by.ansgar.android.booknavigationa.database.entity.Book;
import by.ansgar.android.booknavigationa.reader.fbreader.Text;
import by.ansgar.android.booknavigationa.reader.fbreader.TextImpl;

/**
 * Created by kirila on 15.7.16.
 */
public class BookTextFragment extends Fragment {

    private UUID mId;

    private BookDAO mBookDAO;
    private Book mBook;
    private Text mBookText;

    private TextView mTextView;
    private ScrollView mScrollView;

    public BookTextFragment(UUID id) {
        this.mId = id;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_text, container, false);
        mBookDAO = new BookDAOImpl(getActivity());
        mBook = mBookDAO.getBookById(mId);
        InputStream is = null;
        try {
            is = new FileInputStream(mBook.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        mBookText = new TextImpl(is);

        mTextView = (TextView) view.findViewById(R.id.book_text);
        mScrollView = (ScrollView) view.findViewById(R.id.book_text_scroll_view);
        setBookText();

        return view;
    }

    private void setBookText() {

        List<String> text = mBookText.getText();
        StringBuilder bookText = new StringBuilder(" ");
        for (int i = 0; i < text.size(); i++) {
            bookText.append(text.get(i));
        }
        mTextView.setText(bookText);
    }

}
