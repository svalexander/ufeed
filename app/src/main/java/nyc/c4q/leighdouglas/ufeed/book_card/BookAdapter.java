package nyc.c4q.leighdouglas.ufeed.book_card;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shannonalexander-navarro on 10/30/16.
 */

public class BookAdapter extends RecyclerView.Adapter {


    public BookAdapter(List<Book> books) {
        mBooks = books;
    }

    private List<Book> mBooks = new ArrayList<>();


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BookCardViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        BookCardViewHolder viewHolder = (BookCardViewHolder) holder;

        Book book = mBooks.get(position);
        viewHolder.bind(book);

    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }
}
