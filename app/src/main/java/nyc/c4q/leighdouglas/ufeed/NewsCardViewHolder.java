package nyc.c4q.leighdouglas.ufeed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by shannonalexander-navarro on 1/6/17.
 */

public class NewsCardViewHolder extends RecyclerView.ViewHolder {

    private static View inflateView(ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        //keep an eye on this, might be the wrong thing to inflate?
        return inflater.inflate(R.layout.news_fragment, parent, false);
    }
    public NewsCardViewHolder(ViewGroup parent) {
        super(inflateView(parent));
    }


}
