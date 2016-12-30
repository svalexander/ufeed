package nyc.c4q.leighdouglas.ufeed.grateful_card;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.leighdouglas.ufeed.BookCardViewHolder;
import nyc.c4q.leighdouglas.ufeed.grateful_card.gratitude_model.GratitudeCard;

/**
 * Created by shannonalexander-navarro on 12/23/16.
 */

public class GratitudeAdapter  extends RecyclerView.Adapter{

    List<GratitudeCard> gratitudeCardList = new ArrayList<>();

    public GratitudeAdapter(List<GratitudeCard> gratefulList) {
        this.gratitudeCardList = gratefulList;
    }

//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gratitude_item, parent, false);
//        return new GratitudeViewHolder((ViewGroup) itemView);     }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GratitudeViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GratitudeViewHolder viewHolder = (GratitudeViewHolder) holder;

        GratitudeCard things = gratitudeCardList.get(position);
        viewHolder.bind(things);
    }

    @Override
    public int getItemCount() {
        return gratitudeCardList.size();
    }
}
