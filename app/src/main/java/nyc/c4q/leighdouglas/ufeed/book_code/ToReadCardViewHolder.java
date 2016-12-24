package nyc.c4q.leighdouglas.ufeed.book_code;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nyc.c4q.leighdouglas.ufeed.R;

/**
 * Created by shannonalexander-navarro on 11/12/16.
 */

public class ToReadCardViewHolder extends RecyclerView.ViewHolder {

    TextView textView;

    private static View inflateView(ViewGroup parent) {
        //inflate the view of viewHolder, returns its to the ViewHolder
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.shannon_card, parent, false);
    }
    public ToReadCardViewHolder(ViewGroup parent) {
        super(inflateView(parent));

        textView = (TextView) itemView.findViewById(R.id.tvid);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), BookRecyclerContent.class);
                view.getContext().startActivity(intent);

            }
        });
    }

}
