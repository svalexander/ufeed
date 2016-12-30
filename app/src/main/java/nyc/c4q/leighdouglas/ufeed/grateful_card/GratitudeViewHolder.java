package nyc.c4q.leighdouglas.ufeed.grateful_card;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nyc.c4q.leighdouglas.ufeed.R;

/**
 * Created by shannonalexander-navarro on 12/29/16.
 */

public class GratitudeViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.gratitude_card_layout, parent, false);
    }

    public GratitudeViewHolder(ViewGroup parent) {
        super(inflateView(parent));

        textView = (TextView) itemView.findViewById(R.id.grat_title);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), GratitudeMainActivity.class);
                view.getContext().startActivity(intent);

            }
        });

    }
}
