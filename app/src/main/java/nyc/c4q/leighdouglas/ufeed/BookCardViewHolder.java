package nyc.c4q.leighdouglas.ufeed;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


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
        bookTitleView = (TextView) view.findViewById(R.id.card_text);

    }

    private static View inflateView(View parent) {
        //inflate the view of viewHolder, returns its to the ViewHolder
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.recycled_card, (ViewGroup) parent, false);
    }

    public void bind(final String book) {
        bookTitleView.setText(book); //passes in the titles in the book arrayList
        bookTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), BookActivity.class);
                intent.putExtra("user book", book);
                view.getContext().startActivity(intent);
            }
        });
    }

}
