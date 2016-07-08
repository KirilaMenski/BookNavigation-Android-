package by.ansgar.android.booknavigationa.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import by.ansgar.android.booknavigationa.R;
import by.ansgar.android.booknavigationa.database.dao.BookDAO;
import by.ansgar.android.booknavigationa.database.daoImpl.BookDAOImpl;
import by.ansgar.android.booknavigationa.database.entity.Book;

/**
 * Created by kirila on 8.7.16.
 */
public class BooksFragment extends Fragment {

    private static final String TAG = "BooksFragment";

    private RecyclerView mRecyclerView;
    private ModelAdapter mAdapter;

    private BookDAO mBookDAO;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_books, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.books_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI() {
        mBookDAO = new BookDAOImpl(getActivity());
        List<Book> books = mBookDAO.getAllBooks();
        mAdapter = new ModelAdapter(books);
        mRecyclerView.setAdapter(mAdapter);
    }

    private class ModelHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNumberBook, mBookTitle;
        private CheckBox mReadCheckBox;

        private Book mBook;

        public ModelHolder(View viewItem){
            super(viewItem);
            mNumberBook = (TextView) viewItem.findViewById(R.id.list_item_book_numb_book);
            mNumberBook.setOnClickListener(this);
            mBookTitle = (TextView) viewItem.findViewById(R.id.list_item_book_title_book);
            mBookTitle.setOnClickListener(this);
            mReadCheckBox = (CheckBox) viewItem.findViewById(R.id.list_item_book_read_checkbox);
        }

        public void bindBook(Book book){
            mBook = book;
            mNumberBook.setText("#");
            mBookTitle.setText(mBook.getTitle());
        }

        @Override
        public void onClick(View view) {
            Log.i(TAG, "redirect to book inf fragment");
        }
    }

    private class ModelAdapter extends RecyclerView.Adapter<ModelHolder>{
        private List<Book> mBooksModel;

        public ModelAdapter(List<Book> books){
            mBooksModel = books;
        }

        @Override
        public ModelHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_books, parent, false);
            return new ModelHolder(view);
        }

        @Override
        public void onBindViewHolder(ModelHolder holder, int position) {
            Book book = mBooksModel.get(position);
            holder.bindBook(book);
        }

        @Override
        public int getItemCount() {
            return mBooksModel.size();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }
}
