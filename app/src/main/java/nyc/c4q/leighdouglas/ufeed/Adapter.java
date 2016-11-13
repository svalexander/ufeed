package nyc.c4q.leighdouglas.ufeed;

import android.support.annotation.IntegerRes;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leighdouglas on 10/30/16.
 */

public class Adapter extends RecyclerView.Adapter {
    private List<Integer> mData = Arrays.asList(
            1,2,3,5);

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CardViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CardViewHolder viewHolder = (CardViewHolder) holder;
        Integer myInteger = mData.get(position);
        viewHolder.bind(myInteger);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
