package nyc.c4q.leighdouglas.ufeed;

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
    private TextView bookTitle;
    private View view;

    public BookCardViewHolder(ViewGroup parent) {
        super(inflateView(parent)); //calling the inflate view method which returns the container of our view
        view = itemView;
        bookTitle = (TextView) view.findViewById(R.id.card_text);
    }

    private static View inflateView(View parent) {
        //inflate the view of viewHolder, returns its to the ViewHolder
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.recycled_card, (ViewGroup) parent, false);
    }

    public void bind(String book){

        bookTitle.setText(book); //passes in the titles in the book arrayList

    }

}
