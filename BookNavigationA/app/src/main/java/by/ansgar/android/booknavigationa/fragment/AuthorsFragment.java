package by.ansgar.android.booknavigationa.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.ansgar.android.booknavigationa.R;

/**
 * Created by kirila on 6.7.16.
 */
public class AuthorsFragment extends Fragment {

    private RecyclerView mAuthorsRec;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_authors, container, false);

        mAuthorsRec = (RecyclerView) view.findViewById(R.id.authors_recycler);
        mAuthorsRec.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }
}
