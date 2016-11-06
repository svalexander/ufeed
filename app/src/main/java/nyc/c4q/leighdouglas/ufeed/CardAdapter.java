package nyc.c4q.leighdouglas.ufeed;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by shannonalexander-navarro on 10/30/16.
 */

public class CardAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CardViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
