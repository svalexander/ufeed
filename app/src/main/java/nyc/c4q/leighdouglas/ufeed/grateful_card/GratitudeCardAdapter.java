package nyc.c4q.leighdouglas.ufeed.grateful_card;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.leighdouglas.ufeed.R;
import nyc.c4q.leighdouglas.ufeed.grateful_card.gratitude_model.GratitudeCard;

/**
 * Created by shannonalexander-navarro on 12/23/16.
 */

public class GratitudeCardAdapter extends RecyclerView.Adapter {

    List<GratitudeCard> gratefulList = new ArrayList<>();

    public GratitudeCardAdapter(List<GratitudeCard> gratefulList) {
        this.gratefulList = gratefulList;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gratitude_item, parent, false);
        return new GratitudeCardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GratitudeCardViewHolder viewHolder = (GratitudeCardViewHolder) holder;

        GratitudeCard gratitudeCard = gratefulList.get(position);
        viewHolder.bind(gratitudeCard);
    }

    @Override
    public int getItemCount() {
        return gratefulList.size();
    }
}
