package nyc.c4q.leighdouglas.ufeed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by leighdouglas on 10/30/16.
 */

public class CardViewHolder extends RecyclerView.ViewHolder {

    public CardViewHolder(ViewGroup parent) {

        super(inflateView(parent));
    }

    public static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.recycled_card, parent, false);
    }

    public void bind(Integer integer) {

    }
}
