package nyc.c4q.leighdouglas.ufeed.grateful_card;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shannonalexander-navarro on 12/23/16.
 */

public class GratitudeAdapter  extends RecyclerView.Adapter{

    List<GratitudeCard> gratitudeCardList = new ArrayList<>();
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return gratitudeCardList.size();
    }
}
