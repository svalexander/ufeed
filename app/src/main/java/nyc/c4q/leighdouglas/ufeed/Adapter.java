package nyc.c4q.leighdouglas.ufeed;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import nyc.c4q.leighdouglas.ufeed.grateful_card.GratitudeViewHolder;

/**
 * Created by leighdouglas on 10/30/16.
 */

public class Adapter extends RecyclerView.Adapter {
    private List<Integer> mData = Arrays.asList(
            1, 2, 3, 4 );

    @Override
    public int getItemViewType(int position) {
        switch (mData.get(position)) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            default:

        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case 1:
                return new LeighViewHolder(parent);
            case 2:
                return new ToReadCardViewHolder(parent);
            case 3:
                return new GratitudeViewHolder(parent);
            default:
                return new LeighViewHolder(parent);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)) {
            case 1:
                LeighViewHolder viewHolder = (LeighViewHolder) holder;
                Integer myInteger = mData.get(position);
                viewHolder.bind(myInteger);
                break;
            case 2:
                ToReadCardViewHolder secondHolder = (ToReadCardViewHolder) holder;

                break;
            case 3:
                GratitudeViewHolder thirdHolder = (GratitudeViewHolder) holder;

                break;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}