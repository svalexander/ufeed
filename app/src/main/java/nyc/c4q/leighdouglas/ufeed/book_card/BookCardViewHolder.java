package nyc.c4q.leighdouglas.ufeed.book_card;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nyc.c4q.leighdouglas.ufeed.R;


/**
 * Created by shannonalexander-navarro on 10/30/16.
 */

public class BookCardViewHolder extends RecyclerView.ViewHolder {
    //add editText in the activity b4 the recyclerView
    private TextView bookTitleView;
    private View view;

    public BookCardViewHolder(ViewGroup parent) {
        super(inflateView(parent)); //calling the inflate view method which returns the container of our view
        view = itemView;
        bookTitleView = (TextView) view.findViewById(R.id.recycled_card_title);
    }

    private static View inflateView(View parent) {
        //inflate the view of viewHolder, returns its to the ViewHolder
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.recycled_card, (ViewGroup) parent, false);
    }

    public void bind(Book book) {

        bookTitleView.setText(book.getTitle()); //passes in the titles in the book arrayList

        //don't delete onClick code below, read and revise it
//        bookTitleView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(), BookActivity.class);
//                intent.putExtra(BookActivity.TAG, book);
//                view.getContext().startActivity(intent);
//            }
//        });
    }

}

