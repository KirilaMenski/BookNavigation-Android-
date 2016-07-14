package by.ansgar.android.booknavigationa.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import by.ansgar.android.booknavigationa.R;
import by.ansgar.android.booknavigationa.activity.BookInfActivity;
import by.ansgar.android.booknavigationa.chooser.FileChooser;
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
    private Resources mResources;



    private BookDAO mBookDAO;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_books, container, false);
        mResources = getResources();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.books_recycler);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
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

        private ImageView mCoverBook;

        private Book mBook;

        public ModelHolder(View viewItem) {
            super(viewItem);
            viewItem.setOnClickListener(this);
            mCoverBook = (ImageView) viewItem.findViewById(R.id.list_item_book_cover);
        }

        public void bindBook(Book book) {
            mBook = book;
            //TODO
//            if (mBook.getCover() == null) {
                mCoverBook.setImageDrawable(mResources.getDrawable(R.drawable.default_cover));
//            } else {
//                mCoverBook.setImageDrawable(Drawable.createFromPath(mBook.getCover()));
//            }
        }

        @Override
        public void onClick(View view) {
            Log.i(TAG, "redirect to book inf fragment to " + mBook.getId());
            Intent intent = new Intent(getActivity(), BookInfActivity.class);
            intent.putExtra(BookInfActivity.BOOK_ID, mBook.getId());
            startActivity(intent);
        }
    }

    private class ModelAdapter extends RecyclerView.Adapter<ModelHolder> {
        private List<Book> mBooksModel;

        public ModelAdapter(List<Book> books) {
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_item, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_item_add_book:
                addNewBook();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addNewBook() {
        FileChooser fileChooser = new FileChooser(getActivity()).setFilter(".*\\.txt");
        fileChooser.show();
    }
}
