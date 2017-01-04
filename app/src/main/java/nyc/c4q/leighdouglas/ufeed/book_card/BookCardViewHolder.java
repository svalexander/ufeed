package nyc.c4q.leighdouglas.ufeed.book_card;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nyc.c4q.leighdouglas.ufeed.R;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;
import static nyc.c4q.leighdouglas.ufeed.book_card.BookRecyclerContentActivity.bookDatabase;


/**
 * Created by shannonalexander-navarro on 10/30/16.
 */

public class BookCardViewHolder extends RecyclerView.ViewHolder {

    private TextView bookTitleView;
    private View view;

    public BookCardViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        view = itemView;
        bookTitleView = (TextView) view.findViewById(R.id.recycled_card_title);
    }

    private static View inflateView(View parent) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.recycled_card, (ViewGroup) parent, false);
    }

    public void bind(final Book book) {

        bookTitleView.setText(book.getTitle());

        bookTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), BookActivity.class);
                intent.putExtra(BookActivity.TAG, book);
                view.getContext().startActivity(intent);
            }
        });

        bookTitleView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                cupboard().withDatabase(bookDatabase).get(book);
                BookRecyclerContentActivity.removeBook(book);
                AddBookActivity.refreshUsersBooks();
                return true;
            }
        });
    }

}

